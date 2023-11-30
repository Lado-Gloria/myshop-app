package com.example.myshopapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshopapp.databinding.ActivityMainBinding
import com.example.myshopapp.viewmodel.ProductsViewModel



class MainActivity : AppCompatActivity() {
    val productsViewModel: ProductsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onResume() {
        super.onResume()
        productsViewModel.fetchProducts()

        productsViewModel.errLiveData.observe(this, Observer { err ->
            Toast.makeText(baseContext, err, Toast.LENGTH_LONG).show()
        })

        productsViewModel.productsLiveData.observe(this, Observer { productsList ->
            binding.rvproducts.layoutManager = GridLayoutManager(
                this@MainActivity,
                2
            )
            binding.rvproducts.adapter = ProductAdapter(productsList, this)
        })


    }
}




























