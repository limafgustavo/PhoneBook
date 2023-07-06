package com.gustavolima.myapplicationphonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gustavolima.myapplicationphonebook.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}