package com.example.kt1cl1
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.appcompat.app.AppCompatActivity
import com.example.kt1cl1.databinding.ActivityMainBinding
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerForActivity()
        setupListener()
    }

    private fun setupListener() {
        binding.btnFirst.setOnClickListener {
            if (binding.etData.text.toString() == "") {
            Toast.makeText(this, "заполните поля!", Toast.LENGTH_SHORT).show()
            } else openActivity()
        }
    }

    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.etData.setText(result.data?.getStringExtra(EXTRA_MESSAGE))
                }
            }
    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(EXTRA_MESSAGE, binding.etData.text.toString())
        }
        resultLauncher.launch(intent)
    }
}
