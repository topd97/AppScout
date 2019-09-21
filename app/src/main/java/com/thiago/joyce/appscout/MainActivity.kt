package com.thiago.joyce.appscout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val connectionProps = Properties()
        connectionProps.put("user", "esuGU1HeuI")
        connectionProps.put("password", "CEfR2jPWMw")
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            val conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "remotemysql.com/phpmyadmin/index.php?db=esuGU1HeuI",
                connectionProps)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }
}
