package com.example.kt1cl1
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Toast
import com.example.kt1cl1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()

    }

    private fun setupListener() {

        binding.etData.setText(intent.getStringExtra(EXTRA_MESSAGE))

        binding.btnSecond.setOnClickListener {
            if (binding.etData.text.toString() == "") {
                Toast.makeText(this, "заполните поля!", Toast.LENGTH_SHORT).show()
            } else openActivity()
        }
    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, binding.etData.text.toString())
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}