package com.juanrios66.resistor

import android.os.Bundle
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import com.juanrios66.resistor.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val arraycolors = resources.getStringArray(R.array.color)
        val colors = resources.getIntArray(R.array.colrs)
        

        mainBinding.buttonCalc.setOnClickListener{
            for (num in 0..10 step 1 ){
                if(mainBinding.spinner.selectedItem.toString() == arraycolors[num]){
                    mainBinding.spinner.setBackgroundColor(colors[num])
                }else{
                }
            }
        }

    }
}
