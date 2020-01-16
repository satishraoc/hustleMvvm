package com.satish.hastlemvvmtest.repository;

import androidx.lifecycle.MutableLiveData;

import com.satish.hastlemvvmtest.Api.CartItemsAPIs;
import com.satish.hastlemvvmtest.Api.CartService;
import com.satish.hastlemvvmtest.Api.ProductLists;
import com.satish.hastlemvvmtest.model.CartItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartRepository {

    private static CartRepository cartRepository;
    private CartItemsAPIs cartItemsAPIs;
    MutableLiveData<List<CartItem>> cartProducts = new MutableLiveData<>();

    public static CartRepository getInstance() {
        if (cartRepository == null) {
            cartRepository = new CartRepository();
        }

        return cartRepository;
    }

    public CartRepository() {
        cartItemsAPIs = CartService.createService(CartItemsAPIs.class);
    }


    public MutableLiveData<List<CartItem>> getCartItems() {


        cartItemsAPIs.getList().enqueue(new Callback<ProductLists>() {
            @Override
            public void onResponse(Call<ProductLists> call, Response<ProductLists> response) {
                if (response.isSuccessful()) {
                    cartProducts.setValue(response.body().getProductList());
                }
            }

            @Override
            public void onFailure(Call<ProductLists> call, Throwable t) {
                cartProducts.setValue(null);
            }
        });

        return cartProducts;
    }


}
