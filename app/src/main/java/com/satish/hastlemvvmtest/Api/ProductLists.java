package com.satish.hastlemvvmtest.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.satish.hastlemvvmtest.model.CartItem;

import java.util.List;

public class ProductLists {

    @SerializedName("items")
    @Expose
    private List<CartItem> contacts = null;

    public List<CartItem> getProductList() {
        return contacts;
    }


}
