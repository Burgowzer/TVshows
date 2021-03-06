package com.burgowzer.tvshows

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ViewFlipper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_holder.view.*

class CardViewAdapter: RecyclerView.Adapter<CardViewAdapter.CardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.card_holder,parent,false)

        val holder = CardViewHolder(rootView)

        return holder
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {


        //holder.ViewFiller(show)

    }

    override fun getItemCount(): Int {
        return 10
    }

    class CardViewHolder(rootView: View): RecyclerView.ViewHolder(rootView){

        private val showTitleDB = rootView.showTitle

        fun ViewFiller(show: ShowInfo){

            show.showTitle = showTitleDB.toString()
        }


    }


}