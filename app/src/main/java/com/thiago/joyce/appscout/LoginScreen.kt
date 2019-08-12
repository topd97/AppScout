package com.thiago.joyce.appscout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        button_log_in.setOnClickListener{
            val intent = Intent(this, SelectRamo::class.java)
            startActivity(intent)
        }
    }


}
