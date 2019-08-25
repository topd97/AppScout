package com.thiago.joyce.appscout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_select_ramo.*

class SelectRamo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_ramo)

        lobinhoButton.setOnClickListener(){
            goToListGamesPage("Lobinho")
        }
        escoteiroButton.setOnClickListener(){
            goToListGamesPage("Escoteiro")
        }
        seniorButton.setOnClickListener(){
            goToListGamesPage("Senior")
        }
        pioneiroButton.setOnClickListener(){
            goToListGamesPage("Pioneiro")
        }
        anyButton.setOnClickListener(){
            goToListGamesPage("Qualquer")
        }
    }
    fun goToListGamesPage(ramo:String){
        val intent = Intent(this, GamesListScreen::class.java)

        intent.putExtra(R.string.ramo_selecionado.toString(), ramo)
        startActivity(intent)
    }
}