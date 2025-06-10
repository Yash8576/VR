package com.VRIndustries.vr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.VRIndustries.vr.databinding.ActivityMainBinding
import com.VRIndustries.vr.fragments.CartFragment
import com.VRIndustries.vr.fragments.HomeFragment
import com.VRIndustries.vr.fragments.ProductsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_products -> loadFragment(ProductsFragment())
                R.id.nav_cart -> loadFragment(CartFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}