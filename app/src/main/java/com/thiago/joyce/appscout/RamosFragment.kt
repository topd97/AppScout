package com.thiago.joyce.appscout


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_ramos.*

/**
 * A simple [Fragment] subclass.
 */
class RamosFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ramos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lobinhoButton.setOnClickListener{goToGamesList("Lobinho")};
        escoteiroButton.setOnClickListener{goToGamesList("Escoteiro")};
        seniorButton.setOnClickListener{goToGamesList("Senior")};
        pioneiroButton.setOnClickListener{goToGamesList("Pioneiro")};
        anyButton.setOnClickListener{goToGamesList("Qualquer")};



    }

    fun goToGamesList(ramo: String){
        val action: RamosFragmentDirections.RamoChoosedGoToGamesList = RamosFragmentDirections.ramoChoosedGoToGamesList(ramo)
        findNavController().navigate(action)
    }



}
