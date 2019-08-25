package com.example.piuma

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.animation.AnimatorSet
import android.animation.ObjectAnimator



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        object : CountDownTimer(1000, 1000) {
            override fun onFinish() {
                startAnimation()
            }

            override fun onTick(p0: Long) {}
        }.start()
    }

    fun startAnimation(){
        println("Starting scaling")
        var logo: ImageView = findViewById(R.id.piumaLogo)
        val scaleDownX = ObjectAnimator.ofFloat(logo, "scaleX", 0.5f)
        val scaleDownY = ObjectAnimator.ofFloat(logo, "scaleY", 0.5f)
        val translateX = ObjectAnimator.ofFloat(logo, "translationX", -350f)
        val translateY = ObjectAnimator.ofFloat(logo, "translationY", -700f)
        scaleDownX.duration = 1000
        scaleDownY.duration = 1000
        translateX.duration = 1000
        translateY.duration = 1000

        val scaleDown = AnimatorSet()
        scaleDown.play(scaleDownX).with(scaleDownY).with(translateX).with(translateY)

        scaleDown.start()
    }

}
