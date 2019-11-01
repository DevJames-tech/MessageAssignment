package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


   private val messageList = arrayListOf<Message>(

        Message("hello", "me"),
        Message("hola", "other"),
        Message("today", "me"),
        Message("monday", "other")


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.button)

        initRecyclerView()

        button.setOnClickListener{

            val editText:EditText = findViewById(R.id.editText)
            val randomSender = mutableListOf("me", "other")
            val newMessage = Message(editText.text.toString(), randomSender.random())

            messageList.add(newMessage)
            recyclerView.adapter?.notifyDataSetChanged()
            editText.setText("")
        }



    }

    fun initRecyclerView(){

        val recyclerViewAdapter = RecyclerViewAdapter(messageList)
        recyclerView.adapter = recyclerViewAdapter
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        return when(keyCode){

            KeyEvent.KEYCODE_ENTER -> button.callOnClick()
            else ->  false
        }
    }


}

