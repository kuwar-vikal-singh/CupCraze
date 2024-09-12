package com.axel.cupcraze.Activity

import android.content.Intent
import android.os.Bundle
import com.axel.cupcraze.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    lateinit var bindig : ActivityIntroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        bindig.startBtn.setOnClickListener{
            // Start MainActivity
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))

            // Finish the current IntroActivity
            finish()
        }

    }
}