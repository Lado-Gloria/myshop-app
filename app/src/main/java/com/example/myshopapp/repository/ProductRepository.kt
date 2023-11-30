package com.example.myshopapp.repository

import com.example.myshopapp.api.Apiclient
import com.example.myshopapp.api.Apiinterface
import com.example.myshopapp.model.ProductsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductRepository {
    val apiClient =Apiclient.buildClient(Apiinterface::class.java)
    suspend fun getProducts():Response<ProductsResponse>{
        return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }
    }
}