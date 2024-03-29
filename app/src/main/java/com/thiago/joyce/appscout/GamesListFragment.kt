package com.thiago.joyce.appscout


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_games_list_screen.*

/**
 * A simple [Fragment] subclass.
 */
class GamesListFragment : androidx.fragment.app.Fragment() {

    var gamesArray: Array<String> = emptyArray()
    var ramo_selecionado: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments !=null){
            val argumentsBundle = arguments as Bundle
            val args: GamesListFragmentArgs = GamesListFragmentArgs.fromBundle(argumentsBundle)
            ramo_selecionado = args.selectedRamo
        }

        ramoLabel.setText(ramo_selecionado)

        //Configurações
        configureList()
//        filterButton.setOnClickListener { changePage(FilterScreen::class.java) }
    }

    fun configureList(){

        var listView = lista_jogos

        //Aqui vamos pegar os dados do banco
        gamesArray+= "test1"
        gamesArray+= "test2"
        gamesArray+= "test3"
        gamesArray+= "test4"
        gamesArray+= "test5"
        gamesArray+= "test6"

        if( context != null) {
            val contexto = context as Context
            var arrayAdapter = GameAdapter(contexto, gamesArray)
            listView.adapter = arrayAdapter
        }

//        listView.setOnItemClickListener { parent, view, position, id ->
//            changePage(GameScreen::class.java)
//        }
    }

//    fun changePage(classe: Class<*>){
//        val intent = Intent(this, classe)
//        startActivity(intent)
//    }



}
