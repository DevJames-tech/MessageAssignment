package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class RecyclerViewAdapter(val meList: ArrayList<Message>, val otherList: ArrayList<Message>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

  //  constructor( itemList: ArrayList<Item>) : this() { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {




     val layoutInflater =  LayoutInflater.from(parent.context)

       return ViewHolder(layoutInflater.inflate(R.layout.recyclerview_items, parent, false))
    }

    override fun getItemViewType(position: Int): Int {

        return super.getItemViewType(position)

    }

    override fun getItemCount(): Int {

        if (getItemViewType())
        return meList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView.text = itemList.get(position).title
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textView = itemView.findViewById(R.id.meMessageTextView) as TextView
        val textView = itemView.findViewById(R.id.otherMessageTextView) as TextView


    }


}