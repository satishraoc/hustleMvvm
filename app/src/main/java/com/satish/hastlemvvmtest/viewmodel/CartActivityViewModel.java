package com.satish.hastlemvvmtest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.satish.hastlemvvmtest.Api.ProductLists;
import com.satish.hastlemvvmtest.model.CartItem;
import com.satish.hastlemvvmtest.repository.CartRepository;

import java.util.List;

public class CartActivityViewModel extends ViewModel {

    private MutableLiveData<List<CartItem>> mutableLiveData;
    private CartRepository cartRepository;

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        cartRepository = CartRepository.getInstance();
        mutableLiveData = cartRepository.getCartItems();
    }

    public LiveData<List<CartItem>> getProductsRepo() {
        return mutableLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
