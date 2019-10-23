package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = arrayListOf<Item>(

            Item("Gear"),
            Item("Frog"),
            Item("Apple"),
            Item("Bacon")
        )

        val recyclerViewAdapter = RecyclerViewAdapter(itemList)
        recyclerView.adapter = recyclerViewAdapter
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
    }
}
