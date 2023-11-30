package com.example.myshopapp.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshopapp.model.Product
import com.example.myshopapp.databinding.ProductitemsBinding
import com.squareup.picasso.Picasso

class ProductAdapter(val productsList:List<Product>, var context: Context) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    @SuppressLint("SuspiciousIndentation")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var binding=ProductitemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productsList[position]

        holder.binding.apply {
            tvdescriptions.text = product.description.toString()
            tvname.text = product. title.toString()
            tvprice.text=product.price.toString()

            Picasso
                .get()
                .load(product.thumbnail)
                .resize(100, 100)
                .into(holder.binding.ivProduct)


        }
        holder.binding.cvProducts.setOnClickListener{
            val intent  = Intent (context, ProductDetailsActivity::class.java  )
            intent.putExtra("PRODUCT_ID",product.id)
            intent.putExtra("PRODUCT_TITLE",product.title)
            context.startActivities(arrayOf(intent))

        }


    }
    class ProductViewHolder(var binding: ProductitemsBinding) : RecyclerView.ViewHolder(binding.root){
}
}







