package com.juanrios66.resistor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juanrios66.resistor.databinding.ActivityMainBinding
import kotlin.math.pow


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val colors = resources.getIntArray(R.array.colrs)

        mainBinding.buttonCalc.setOnClickListener {
            val color1 = mainBinding.spinner.selectedItemId.toInt()
            val color2 = mainBinding.spinner2.selectedItemId.toInt()
            val color3 = mainBinding.spinner3.selectedItemId.toInt()
            mainBinding.spinner.setBackgroundColor(colors[color1])
            mainBinding.spinner2.setBackgroundColor(colors[color2])
            mainBinding.spinner3.setBackgroundColor(colors[color3])

            val res = ((color1.toDouble()) * 10.0 + (color2.toDouble())) * 10.0.pow(color3.toDouble())
            mainBinding.resultado.text = "$res Ohm"
        }
    }
}
