package com.satish.hastlemvvmtest.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartItem {

    @SerializedName("itemId")
    @Expose
    private String itemId;
    @SerializedName("itemName")
    @Expose
    private String itemName;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("quantityUnit")
    @Expose
    private String quantityUnit;
    @SerializedName("itemUrl")
    @Expose
    private String itemUrl;
    @SerializedName("price")
    @Expose
    private String price;

    public CartItem(String itemId, String itemName, String quantity, String quantityUnit, String itemUrl, String price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
        this.itemUrl = itemUrl;
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }





    @Override
    public String toString() {
        return "CartItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", quantityUnit='" + quantityUnit + '\'' +
                ", itemUrl='" + itemUrl + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}