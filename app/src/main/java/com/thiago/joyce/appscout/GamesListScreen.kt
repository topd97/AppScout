package com.thiago.joyce.appscout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_games_list_screen.*

class GamesListScreen : AppCompatActivity() {

    var gamesArray: Array<String> = emptyArray()
    var ramo_selecionado: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games_list_screen)

        ramo_selecionado = intent.getStringExtra(R.string.ramo_selecionado.toString())
        ramoLabel.setText(ramo_selecionado)

        //Configurações
        configureList()
        filterButton.setOnClickListener { changePage(FilterScreen::class.java) }
    }

    fun configureList(){

        var listView = findViewById<ListView>(R.id.lista_jogos)

        //Aqui vamos pegar os dados do banco
        gamesArray+= "test1"
        gamesArray+= "test2"
        gamesArray+= "test3"
        gamesArray+= "test4"
        gamesArray+= "test5"
        gamesArray+= "test6"

        var arrayAdapter = GameAdapter(this, gamesArray)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            changePage(GameScreen::class.java)
        }
    }

    fun changePage(classe: Class<*>){
        val intent = Intent(this, classe)
        startActivity(intent)
    }


}
