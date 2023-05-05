package com.example.a3week_memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.a3week_memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var memoText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goBtn.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", binding.EditText.text.toString())
            startActivity(intent)
        }

        Log.d("Lifecycle", "onCreate")
    }

    override fun onPause() {
        super.onPause()
        memoText = binding.EditText.text.toString()

    }

    override fun onResume() {
        super.onResume()
        val memodata = memoText.toString()
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop")
    }


    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this)
            .setTitle("근디 할말이 있음")
            .setMessage("자네,,,, 더 쓸건가,,,?")
            .setPositiveButton("예") {dialog, which ->
                binding.EditText.setText(memoText)
            }
            .setNegativeButton("아니요") {dialog, which ->
                binding.EditText.text.clear()
            }
            .create()
            .show()

        Log.d("Lifecycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy")
    }
}

