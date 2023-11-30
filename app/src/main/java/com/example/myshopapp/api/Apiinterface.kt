package com.example.myshopapp.api


import android.security.identity.AccessControlProfileId
import com.example.myshopapp.model.Product
import com.example.myshopapp.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface Apiinterface {
    @GET("/product")
 suspend fun getProducts():Response<ProductsResponse>



    @GET("/product")
suspend fun getproductsById(@Path("id")productId: Int):Response<Product>

}

    

