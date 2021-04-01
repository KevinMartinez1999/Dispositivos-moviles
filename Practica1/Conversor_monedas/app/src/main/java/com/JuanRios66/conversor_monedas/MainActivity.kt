package com.JuanRios66.conversor_monedas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.JuanRios66.conversor_monedas.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.convertir.setOnClickListener {
            val money_from = mainBinding.spinner3.selectedItem.toString()
            val money_to = mainBinding.spinner4.selectedItem.toString()
            val num1 = mainBinding.number1.text.toString()
            val dec = DecimalFormat("###,###,###,###,###,###,###.##")

            if (num1.isNotEmpty()) {
                if (money_from == getString(R.string.cop)) {
                    if (money_to == getString(R.string.usd)) {
                        mainBinding.number2.setText(dec.format(num1.toFloat() * 0.00028F).toString())
                    } else if (money_to == getString(R.string.eur)) {
                        mainBinding.number2.setText(dec.format(num1.toFloat() * 0.00024F).toString())
                    } else {
                        mainBinding.number2.setText(num1)
                    }
                } else if (money_from == getString(R.string.usd)) {
                    if (money_to == getString(R.string.cop)) {
                        mainBinding.number2.setText(dec.format(num1.toFloat() * 3357.3F).toString())
                    } else if (money_to == getString(R.string.eur)) {
                        mainBinding.number2.setText(dec.format(num1.toFloat() * 0.83F).toString())
                    } else {
                        mainBinding.number2.setText(num1)
                    }
                } else {
                    if (money_to == getString(R.string.cop)) {
                        mainBinding.number2.setText(dec.format(num1.toFloat() * 4281.58F).toString())
                    } else if (money_to == getString(R.string.usd)) {
                        mainBinding.number2.setText(dec.format(num1.toFloat() * 1.20F).toString())
                    } else {
                        mainBinding.number2.setText(num1)
                    }
                }
            } else {
                Toast.makeText(this, getString(R.string.error_value), Toast.LENGTH_LONG).show()
            }
        }
    }
}