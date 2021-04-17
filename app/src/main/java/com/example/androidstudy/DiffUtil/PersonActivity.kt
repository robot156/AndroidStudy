package com.example.androidstudy.DiffUtil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidstudy.databinding.ActivityPersonBinding

class PersonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonBinding

    private lateinit var adapter : RecyclerviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPersonBinding.inflate(layoutInflater)

        setContentView(binding.root)

        adapter = RecyclerviewAdapter()

        binding.personRv.adapter = adapter
        binding.personRv.layoutManager = LinearLayoutManager(this)
        binding.personRv.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.HORIZONTAL))


        binding.addBtn.setOnClickListener {

            adapter.addList()

        }

        binding.deleteBtn.setOnClickListener {
            adapter.deleteList()
        }


    }
}