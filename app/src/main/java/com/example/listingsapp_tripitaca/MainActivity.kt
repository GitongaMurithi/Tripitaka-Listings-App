package com.example.listingsapp_tripitaca

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listingsapp_tripitaca.data.dto.ListingsDto
import com.example.listingsapp_tripitaca.databinding.ActivityMainBinding
import com.example.listingsapp_tripitaca.presentation.viewModel.ListingDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ListingsAdapter
    private lateinit var properties: List<ListingsDto>
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: ListingDetailsViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ListingDetailsViewModel::class.java]

        properties = viewModel.listings()
        Log.d("JOY" , properties[1].location.name)
        adapter = ListingsAdapter(this, properties)
        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle query submission if needed
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterPropertyByLocation(newText)
                return true
            }
        })
    }

    fun filterPropertyByLocation(queryLocation: String?) {
        Log.d("LOCATION" , properties.size.toString())
        val filtredProperties = properties.filter { it.location.name.contains(queryLocation.orEmpty() , ignoreCase = true) }
        Log.d("LOCATION" , filtredProperties.size.toString())
        adapter = ListingsAdapter(this , filtredProperties)
        recyclerView.adapter = adapter

    }
}