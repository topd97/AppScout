package com.thiago.joyce.appscout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_screen.*

class gameScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        var ramo_selecionado = intent.getStringExtra(R.string.ramo_selecionado.toString())
        ramoLabel.setText(ramo_selecionado)

        //lista_jogos.
    }
}
