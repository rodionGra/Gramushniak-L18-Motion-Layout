package com.a12acdhmwmotionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.a12acdhmwmotionlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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

    private fun setupMotionListener(){
        binding.motionLayoutBase.doOnEnd {
            //TODO CLEAN UP
            //binding.button9.isEnabled = !binding.button9.isEnabled
        }
    }

    private fun setupListeners() {
        binding.button9.setOnClickListener {
            Toast.makeText(this, "button9", Toast.LENGTH_SHORT).show()
        }
    }

    private fun MotionLayout.doOnEnd(block: () -> Unit){
        setTransitionListener(
            object : TransitionAdapter(){
                override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) = block()
            }
        )
    }
}