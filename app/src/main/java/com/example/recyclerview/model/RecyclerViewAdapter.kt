package com.example.recyclerview.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.activity_main.*


class RecyclerViewAdapter( var messageList: ArrayList<Message>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    fun addMessagge(message:Message){
       messageList.add(message)
        notifyDataSetChanged()
        
    }


    fun deleteMessage(){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {

            1 -> return ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item_other, parent, false))
            0 -> return ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item_me, parent, false))
            else  -> return ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item_other, parent, false))
        }

    }

    override fun getItemViewType(position: Int): Int {

        val message = messageList.get(position)

        if(message.sender == "John"){

            return 1

        } else {

            return 0
        }



    }

    override fun getItemCount(): Int {

        return messageList.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvSender?.text = messageList.get(position).sender
        holder.tvMessage?.text = messageList.get(position).message





    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

       val tvMessage = itemView.findViewById(R.id.tvMessage) as TextView?
        val tvSender = itemView.findViewById(R.id.tvSender) as TextView?






    }


}