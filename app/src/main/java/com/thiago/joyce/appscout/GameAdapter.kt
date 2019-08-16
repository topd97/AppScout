package com.thiago.joyce.appscout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.row_game.view.*

class GameAdapter(context: Context, itensList: Array<String>): BaseAdapter() {

    private val parentContext: Context
    private val itensInListView: Array<String>

    init{
        parentContext = context
        itensInListView = itensList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val textView = TextView(parentContext)
//        textView.text = itensInListView[position]
//        return text
        val layoutInflater = LayoutInflater.from(parentContext)
        val rowGame = layoutInflater.inflate(R.layout.row_game, parent, false)
        rowGame.titulo.setText("Titulo: " + itensInListView[position])
        return rowGame

    }

    override fun getItem(position: Int): Any {
        return itensInListView[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return itensInListView.count()
    }


}