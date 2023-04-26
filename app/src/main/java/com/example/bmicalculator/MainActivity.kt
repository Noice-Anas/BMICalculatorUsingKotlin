package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightPicker.minValue = 30
        binding.weightPicker.maxValue = 150

        binding.heightPicker.minValue = 100
        binding.heightPicker.maxValue = 250

        binding.buttonCalculate.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI()
    {
        val height = binding.heightPicker.value
        val doubleHeight = height.toDouble() / 100

        val weight = binding.weightPicker.value

        val bmi = weight.toDouble() / (doubleHeight * doubleHeight)

        binding.resultsTV.text = String.format("Your BMI is: %.2f", bmi)

        binding.healthyTV.text = String.format("Considered: %s", healthyMessage(bmi))

    }

    private fun healthyMessage(bmi: Double): String
    {
        if (bmi < 18.5) {
            binding.healthyTV.setTextColor(Color.RED)
            return "Underweight"
        }
        if(bmi < 25.0) {
            binding.healthyTV.setTextColor(Color.GREEN)
            return "Healthy"
        }
        if (bmi < 30.0) {
            binding.healthyTV.setTextColor(Color.RED)
            return "Overweight"
        }

        binding.healthyTV.setTextColor(Color.RED)
        return "Obese"
    }
}







