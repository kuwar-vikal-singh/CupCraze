package com.axel.cupcraze.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.axel.cupcraze.Adapter.CartAdapter
import com.axel.cupcraze.Helper.ChangeNumberItemsListener
import com.axel.cupcraze.R
import com.axel.cupcraze.databinding.ActivityCartBinding
import com.example.project1762.Helper.ManagmentCart

class CartActivity : BaseActivity() {

    lateinit var binding :ActivityCartBinding
    lateinit var managmet : ManagmentCart
    private var tax : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmet = ManagmentCart(this)

        calculateCart()
        setVariable()
        initCartList()

    }

    private fun initCartList() {
        with(binding){
           cartView.layoutManager = LinearLayoutManager(this@CartActivity,LinearLayoutManager.VERTICAL,false)
            cartView.adapter = CartAdapter(managmet.getListCart(),this@CartActivity,object:ChangeNumberItemsListener{
                override fun onChanged() {
                    binding.cartView.post {
                        calculateCart()
                    }
                }

            } )

        }
    }

    private fun setVariable() {
        binding.backBtn.setOnClickListener{
            finish()
        }

    }

    private fun calculateCart(){

        val percentTax= 0.02
        val delivery = 15.0
        tax = Math.round((managmet.getTotalFee()*percentTax)*100)/100.0
        val total = Math.round((managmet.getTotalFee()*100))/100
        val  itemTotal = Math.round((managmet.getTotalFee()*100)/100)

        with(binding){
            totalFeeTxt.text= "$$itemTotal"
            taxTxt.text="$$tax"
            deliveryText.text="$$delivery"
            totalTxt.text="$$total"

        }


    }
}