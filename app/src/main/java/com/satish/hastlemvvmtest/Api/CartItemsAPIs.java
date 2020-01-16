package com.satish.hastlemvvmtest.Api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CartItemsAPIs {

    @GET("5e1dc3b53600005a00c743c9")
    Call<ProductLists> getList();

}
