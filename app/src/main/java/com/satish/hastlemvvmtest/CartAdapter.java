package com.satish.hastlemvvmtest;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.satish.hastlemvvmtest.databinding.RowCartItemsBinding;
import com.satish.hastlemvvmtest.interf.AmountIntf;
import com.satish.hastlemvvmtest.interf.ButtonClicked;
import com.satish.hastlemvvmtest.model.CartItem;


import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Activity activity;
    private List<CartItem> cartList;
    private AmountIntf amountIntf;
    private int totalItem = 0;
    private RowCartItemsBinding binding;
    private String TAG = "CardAdapterLogd";
    private CartViewHolder mHolder;

    CartAdapter(Activity activity, List<CartItem> cartList, AmountIntf amountIntf) {
        this.activity = activity;
        this.cartList = cartList;
        this.amountIntf = amountIntf;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_cart_items, parent, false);

        return new CartViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        mHolder = holder;
        CartItem cartItem = cartList.get(position);
        holder.bind(cartItem);
        holder.rowCartItemsBinding.ibPlus.setOnClickListener(view -> increment( holder.rowCartItemsBinding,Integer.parseInt(cartList.get(position).getPrice())));
        holder.rowCartItemsBinding.ibMinus.setOnClickListener(view -> decrement( holder.rowCartItemsBinding,Integer.parseInt(cartList.get(position).getPrice())));

    }


    private void increment(RowCartItemsBinding holder, int price) {

        int count = Integer.parseInt(holder.tvCount.getText().toString());
        if(count==0){
            totalItem = totalItem+1;
        }
        holder.tvCount.setText(String.valueOf(count + 1));
        amountIntf.setAmount(price,0,totalItem);

    }

    private void decrement(RowCartItemsBinding holder, int price) {
        int count = Integer.parseInt(holder.tvCount.getText().toString());

        if (count != 0) {
            if(count==1){
                totalItem = totalItem-1;
            }
            holder.tvCount.setText(String.valueOf(count - 1));
            amountIntf.setAmount(price, 1,totalItem);

        }

    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {

        RowCartItemsBinding rowCartItemsBinding;

        public CartViewHolder(RowCartItemsBinding rowCartItemsBinding) {
            super(rowCartItemsBinding.getRoot());
            this.rowCartItemsBinding = rowCartItemsBinding;
        }

        public void bind(Object obj) {
            rowCartItemsBinding.setVariable(BR.cartItem, obj);
            rowCartItemsBinding.executePendingBindings();

        }
    }


}