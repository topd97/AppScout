package com.thiago.joyce.appscout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_games_list_screen.*

class GamesListScreen : AppCompatActivity() {

    //isso ta pessimo, descobrir como usar lazy!!!
//    var listView: ListView
    var gamesArray: Array<String> = emptyArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games_list_screen)

        var ramo_selecionado = intent.getStringExtra(R.string.ramo_selecionado.toString())
        ramoLabel.setText(ramo_selecionado)

        configureList()
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
            goToGamesPage()
        }
    }

    fun goToGamesPage(){
        val intent = Intent(this, GameScreen::class.java)
        startActivity(intent)
    }


}
