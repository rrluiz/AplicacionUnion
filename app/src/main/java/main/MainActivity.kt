package main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.aplicacionunion.R
import fragment.HomeFragment
import fragment.NewsFragment
import fragment.ProductFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val productFragment = ProductFragment()
        val newsFragment = NewsFragment()

        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.products -> setCurrentFragment(productFragment)
                R.id.news -> setCurrentFragment(newsFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment:Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.flFragment, fragment)
        commit()
    }
}