package com.example.myshopapp.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myshopapp.R
import com.example.myshopapp.api.Apiclient
import com.example.myshopapp.api.Apiinterface
import com.example.myshopapp.databinding.ActivityProductDetailBinding
import com.example.myshopapp.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    private lateinit var apiinterface: Apiinterface
    private var productId = -1
    private var product: Product? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiinterface = Apiclient.buildClient(Apiinterface::class.java)

        val bundle = intent.extras
        if (bundle != null) {
            productId = bundle.getInt("PRODUCT_ID", -1)
        }

        fetchProductDetails()
    }

    private fun fetchProductDetails() {
        GlobalScope.launch(Dispatchers.Main) {
            // Make the API call to fetch product details using 'productId'
            val response = apiinterface.getproductsById(productId)

            if (response.isSuccessful) {
                // API call successful, retrieve product details from the response
                product = response.body()

                // Display product details in the UI
                runOnUiThread {
                    displayProductDetails()
                }
            } else {
                runOnUiThread {
                    Toast.makeText(
                        this@ProductDetailsActivity,
                        "Failed to fetch product details",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun displayProductDetails() {
        // Check if product is not null and display its details in the UI
        product?.let {

        }




//            binding.tvname.text = it.des
//            cription
//             Display other product details as needed
//             For example, if you have an ImageView with id 'imageView', you can display the thumbnail as follows:
//             Picasso.get().load(it.thumbnail).into(binding.imageView)
        }
    }
