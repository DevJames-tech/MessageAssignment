package com.example.recyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.model.Message
import com.example.recyclerview.R
import com.example.recyclerview.model.RecyclerViewAdapter
import com.example.recyclerview.model.network.RetrofitResponse
import com.example.recyclerview.viewmodel.MessageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :  FragmentActivity() {


    private lateinit var listOfMessages: List<Message>
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

        val viewModel = ViewModelProviders.of(this).get(MessageViewModel::class.java)

        loadMessages()
            initRecyclerView(listOfMessages)

        button.setOnClickListener{

            val editText:EditText = findViewById(R.id.editText)
            val randomSender = mutableListOf("me", "other")
            val newMessage =
                Message(
                    editText.text.toString(),
                    randomSender.random()
                )

           /* messageList.add(
                Message(
                    viewModel.getDataFromRepo().get(0).message,
                    viewModel.getDataFromRepo().get(0).sender))
            recyclerView.adapter?.notifyDataSetChanged()
            editText.setText("")*/
        }



    }

    fun initRecyclerView(messageList: List<Message>){

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

    fun loadMessages(){

        val reponse = RetrofitResponse()

       listOfMessages = reponse.initNetorkCall()
    }


}

