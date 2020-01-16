package com.satish.hastlemvvmtest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.satish.hastlemvvmtest.Api.CartItemsAPIs;
import com.satish.hastlemvvmtest.Api.CartService;
import com.satish.hastlemvvmtest.databinding.ActivityMainBinding;
import com.satish.hastlemvvmtest.interf.AmountIntf;
import com.satish.hastlemvvmtest.model.CartItem;
import com.satish.hastlemvvmtest.viewmodel.CartActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements AmountIntf {
    private CartActivityViewModel cartActivityViewModel;
    private List<CartItem> list = new ArrayList<>();
    private CartAdapter cartlistAdapter;
    private ActivityMainBinding binding;

    public TextView tvItems;
    public TextView tvTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        cartActivityViewModel = ViewModelProviders.of(this).get(CartActivityViewModel.class);
        cartActivityViewModel.init();


        cartActivityViewModel.getProductsRepo().observe(this, cartItems -> {
            list = cartItems;
            populateData();
        });


    }

    private void init() {
        CartService.getServices().create(CartItemsAPIs.class);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.include_toolbar, null);
        tvTotalPrice = mCustomView.findViewById(R.id.tvTotalPrice);
        tvItems = mCustomView.findViewById(R.id.tvItems);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }


    private void populateData() {
        if (cartlistAdapter == null) {
            cartlistAdapter = new CartAdapter(CartActivity.this, list, this);
            binding.setMyAdapter(cartlistAdapter);
        }
    }


    @Override
    public void setAmount(int price, int state, int totalItem) {

        int totalAmt = Integer.parseInt(tvTotalPrice.getText().toString());
        tvItems.setText(totalItem + " items");
        if (state == 0) {
            tvTotalPrice.setText(String.valueOf((totalAmt + price)));
        } else {
            tvTotalPrice.setText(String.valueOf((totalAmt - price)));

        }
    }
}
