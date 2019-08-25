package com.thiago.joyce.appscout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.R.array
import android.widget.ArrayAdapter
import android.widget.Spinner



class FilterScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_screen)

        configureDropDown(R.id.AreaDrop, R.array.FisecaArray)
        configureDropDown(R.id.compDrop, R.array.CompArray)
        configureDropDown(R.id.locationDrop, R.array.LocationArray)

    }

    fun configureDropDown(idSpinner: Int, arrayStrings: Int){
        var spinner = findViewById(idSpinner) as Spinner

        val adapter = ArrayAdapter.createFromResource(this, arrayStrings, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}
