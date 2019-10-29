package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val messageList = arrayListOf<Message>(

        Message("hello", "me"),
        Message("hola", "other"),
        Message("today", "me"),
        Message("monday", "other")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

    }

    fun initRecyclerView(){


        val recyclerViewAdapter = RecyclerViewAdapter(messageList)
        recyclerView.adapter = recyclerViewAdapter
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
    }

    fun onClick(view: View) {

        val editText = view.findViewById<EditText>(R.id.editText)
        val randomSender = mutableListOf("me", "other")

        val newMessage = Message(editText.text.toString(), randomSender.random())

        messageList.add(newMessage )
    }


}
