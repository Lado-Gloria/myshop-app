package com.example.myshopapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshopapp.model.Product
import com.example.myshopapp.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductsViewModel :ViewModel(){
    val productsRepo =ProductRepository()
    val productsLiveData =MutableLiveData<List<Product>>()
    val errLiveData =MutableLiveData<String>()


    fun fetchProducts(){
        viewModelScope.launch {
        val response =productsRepo.getProducts()
        if (response.isSuccessful){
            productsLiveData.postValue(response.body()?.products)
        }
        else{
            errLiveData.postValue(response.errorBody()?.string())

        }
    }

    }
}