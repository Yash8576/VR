package com.VRIndustries.vr.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.VRIndustries.vr.R
import com.VRIndustries.vr.adapters.ProductAdapter
import com.VRIndustries.vr.databinding.FragmentProductsBinding
import com.VRIndustries.vr.model.Product

class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    private val productList = listOf(
        Product("Fresh Cow Milk", "₹ 50 / litre", R.drawable.ic_milk),
        Product("Organic Ghee", "₹ 500 / kg", R.drawable.ic_ghee),
        Product("Butter", "₹ 400 / kg", R.drawable.ic_butter),
        Product("Paneer", "₹ 300 / kg", R.drawable.ic_paneer),
        Product("Curd", "₹ 40 / cup", R.drawable.ic_curd)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ProductAdapter(productList) { selectedProduct ->
            val detailFragment = ProductDetailFragment.newInstance(
                selectedProduct.name,
                selectedProduct.price,
                selectedProduct.imageResId
            )

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.productRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.productRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}