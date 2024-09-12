package com.axel.cupcraze.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.axel.cupcraze.R
import com.axel.cupcraze.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set a delay of 3 seconds (3000 milliseconds)
        Handler(Looper.getMainLooper()).postDelayed({
            // Navigate to the IntroActivity after 3 seconds
            val intent = Intent(this@SplashActivity, IntroActivity::class.java)
            startActivity(intent)

            // Apply smooth transition animations
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

            finish() // Close the SplashActivity
        }, 3000) // 3 second delay
    }
}
