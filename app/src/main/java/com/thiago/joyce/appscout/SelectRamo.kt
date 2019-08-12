package com.thiago.joyce.appscout

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_select_ramo.*

class SelectRamo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_ramo)

        lobinhoButton.setOnClickListener(){
            goToGamesPage("Lobinho")
        }
        escoteiroButton.setOnClickListener(){
            goToGamesPage("Escoteiro")
        }
        seniorButton.setOnClickListener(){
            goToGamesPage("Senior")
        }
        pioneiroButton.setOnClickListener(){
            goToGamesPage("Pioneiro")
        }
        anyButton.setOnClickListener(){
            goToGamesPage("Qualquer")
        }
    }
    fun goToGamesPage(ramo:String){
        val intent = Intent(this, gameScreen::class.java)
        intent.putExtra("Ramo", ramo)
        startActivity(intent)
    }
}