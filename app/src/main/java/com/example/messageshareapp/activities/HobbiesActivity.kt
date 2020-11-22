package com.example.messageshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.messageshareapp.adapter.HobbiesAdapter
import com.example.messageshareapp.R
import com.example.messageshareapp.models.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

        //here you can use any layout manager whether linearLayoutManager,
        // GridLayoutManager, staggeredLayoutManager or any of other types of layoutManager
        // and set orientation as well

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerView.layoutManager = layoutManager

        //initialise the adapter created
        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        recyclerView.adapter = adapter
    }
}
