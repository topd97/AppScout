package com.thiago.joyce.appscout


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner

/**
 * A simple [Fragment] subclass.
 */
class FilterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureDropDown(R.id.AreaDrop, R.array.FisecaArray)
        configureDropDown(R.id.compDrop, R.array.CompArray)
        configureDropDown(R.id.locationDrop, R.array.LocationArray)
    }

    fun configureDropDown(idSpinner: Int, arrayStrings: Int){
        var spinner = view?.findViewById(idSpinner) as Spinner

        val adapter = ArrayAdapter.createFromResource(view?.context, arrayStrings, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }



}
