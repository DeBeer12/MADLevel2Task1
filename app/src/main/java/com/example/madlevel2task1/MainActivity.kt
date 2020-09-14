package com.example.madlevel2task1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.madlevel2task1.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    private val places = arrayListOf<Place>()
    private val placeAdapter = PlaceAdapter(places)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initViews()
    }

    fun initViews() {
        binding.rvPlaces.layoutManager =
            StaggeredGridLayoutManager(2, DividerItemDecoration.VERTICAL)
        binding.rvPlaces.adapter = placeAdapter
        for (i in Place.PLACE_NAMES.indices) {
            places.add(Place(Place.PLACE_NAMES[i],        Place.PLACE_RES_DRAWABLE_IDS[i]))

        }
        placeAdapter.notifyDataSetChanged()
    }
}