package com.example.myshopapp.model

import com.example.myshopapp.model.Product

data class ProductsResponse(
    var name: String,
    var products:List<Product>,
    var total: Int,
    var skip:Int,
    var limit:Int,

    )
