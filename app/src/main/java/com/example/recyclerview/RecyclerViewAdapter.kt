package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class RecyclerViewAdapter(val messageList: ArrayList<Message>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

  //  constructor( itemList: ArrayList<Item>) : this() { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {




     val layoutInflater =  LayoutInflater.from(parent.context)

       return ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item_other, parent, false))
    }

    override fun getItemViewType(position: Int): Int {

        return super.getItemViewType(position)

    }

    override fun getItemCount(): Int {

       // if (getItemViewType())
        return messageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView.text = messageList.get(position).message.plus(messageList.get(position).sender)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textView = itemView.findViewById(R.id.textView) as TextView


    }


}