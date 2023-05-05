package com.example.a3week_memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a3week_memo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Secondtext.text = intent.getStringExtra("data")
    }
}