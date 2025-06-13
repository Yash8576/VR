package com.VRIndustries.vr.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.VRIndustries.vr.R

class ProductDetailFragment : Fragment() {

    private var productName: String? = null
    private var productPrice: String? = null
    private var productImageResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            productName = it.getString("name")
            productPrice = it.getString("price")
            productImageResId = it.getInt("image", R.drawable.ic_products)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameTextView = view.findViewById<TextView>(R.id.productDetailName)
        val priceTextView = view.findViewById<TextView>(R.id.productDetailPrice)
        val imageView = view.findViewById<ImageView>(R.id.productDetailImage)

        nameTextView.text = productName
        priceTextView.text = productPrice
        imageView.setImageResource(productImageResId ?: R.drawable.ic_products)
    }

    companion object {
        fun newInstance(name: String, price: String, imageResId: Int): ProductDetailFragment {
            val fragment = ProductDetailFragment()
            val args = Bundle()
            args.putString("name", name)
            args.putString("price", price)
            args.putInt("image", imageResId)
            fragment.arguments = args
            return fragment
        }
    }
}