package com.juanrios66.resistor

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
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
        val tolerance = resources.getIntArray(R.array.toler)

        mainBinding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                mainBinding.spinner.setBackgroundColor(resources.getColor(R.color.design_default_color_background))
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                mainBinding.spinner.setBackgroundColor(colors[mainBinding.spinner.selectedItemId.toInt()])
            }
        }
        mainBinding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                mainBinding.spinner2.setBackgroundColor(colors[mainBinding.spinner2.selectedItemId.toInt()])
            }
        }
        mainBinding.spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                mainBinding.spinner3.setBackgroundColor(colors[mainBinding.spinner3.selectedItemId.toInt()])
            }
        }
        mainBinding.spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                mainBinding.spinner4.setBackgroundColor(tolerance[mainBinding.spinner4.selectedItemId.toInt()])
            }
        }


        mainBinding.buttonCalc.setOnClickListener {
            val color1 = mainBinding.spinner.selectedItemId.toInt()-1
            val color2 = mainBinding.spinner2.selectedItemId.toInt()-1
            val color3 = mainBinding.spinner3.selectedItemId.toInt()-1
            val color4 = mainBinding.spinner4.selectedItemId.toInt()-1
            var result: String
            val res =
                (((color1.toDouble() * 10.0) + (color2.toDouble())) * 10.0.pow(color3.toDouble()))
            if (color1==-1 || color2==-1 || color3==-1){
                Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
            }else{
                when {
                    res < 1000 -> {
                        result = res.toString().plus(" " + getString(R.string.ohm))
                    }
                    (res >= 1000) and (res <= 1000000) -> {
                        result = (res / 1000).toString().plus(" " + getString(R.string.Kohm))
                    }
                    else -> {
                        result=(res / 1000000).toString().plus(" " + getString(R.string.Mohm))
                    }
                }
                if (color4 == 0){
                    result = result + "\n" + getString(R.string.Tolerancia5)
                }else{
                    result = result + "\n" + getString(R.string.Tolerancia10)
                }
                mainBinding.resultado.text = result
            }

        }

    }
}
