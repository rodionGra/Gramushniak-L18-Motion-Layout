package com.a12acdhmwmotionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.a12acdhmwmotionlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val keyPositionForEnabled = 0.5F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupListeners()
        setupMotionListener()
    }

    private fun setupBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
    }

    private fun setupMotionListener(){
        binding.motionLayoutBase.doOnMiddle {
            binding.apply {
                button7.isEnabled = it > keyPositionForEnabled
                button8.isEnabled = it > keyPositionForEnabled
                button9.isEnabled = it > keyPositionForEnabled
            }
        }
    }

    private fun MotionLayout.doOnMiddle(block: (Float) -> Unit){
        setTransitionListener(
            object : TransitionAdapter(){
                override fun onTransitionChange(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                    progress: Float
                ) = block(progress)
            }
        )
    }
}