package com.example.recyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.model.Message
import com.example.recyclerview.R
import com.example.recyclerview.model.RecyclerViewAdapter
import com.example.recyclerview.model.network.RetrofitResponse
import com.example.recyclerview.viewmodel.MessageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :  AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var isSender: Boolean = false
    private lateinit var newMessage: Message
    private lateinit var listOfMessages: List<Message>
    /*private val messageList = arrayListOf<Message>(

       Message("hello", "me"),
       Message("hola", "other"),
       Message("today", "me"),
       Message("monday", "other")


    )*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val spinner: Spinner = findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            this, R.array.spinner, R.layout.spinner_item).also{ spinner.adapter = it }

        spinner.onItemSelectedListener = this

        //  val viewModel = ViewModelProviders.of(this).get(MessageViewModel::class.java)

        initMessages()

        button.setOnClickListener {

            val editText: EditText = findViewById(R.id.editText)



            when(isSender){

                false ->{ newMessage =  Message(editText.text.toString(), "Me")}

                true -> { newMessage =  Message(editText.text.toString(), "John")}
            }

            (recyclerView.adapter as RecyclerViewAdapter).addMessagge(newMessage)
            recyclerView.scrollToPosition(recyclerView.adapter!!.itemCount-1) // adds adapter sets index from get item count -1 cuz count is one greater


            editText.setText("")
        }


    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        if(pos == 1){ isSender = true }

        if (pos == 0){ isSender = false}



    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true//super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.deleteButton -> {(recyclerView.adapter as RecyclerViewAdapter).deleteMessage()} }

        return super.onOptionsItemSelected(item)
    }

    fun initRecyclerView(messages: ArrayList<Message>) {

        Log.d("TAG", " here is REcycler")

        val recyclerViewAdapter = RecyclerViewAdapter(messages)
        recyclerView.adapter = recyclerViewAdapter
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        return when (keyCode) {

            KeyEvent.KEYCODE_ENTER -> button.callOnClick()
            else -> false
        }
    }


    fun initMessages() {

        val response = RetrofitResponse()


        response.initNetorkCall().observe(this, Observer { messages -> initRecyclerView(messages as ArrayList<Message>)
        })


    }
}

