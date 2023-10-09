package com.example.listingsapp_tripitaca

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.listingsapp_tripitaca.data.dto.ListingsDto
import com.example.listingsapp_tripitaca.databinding.ActivityListingsDetailsBinding
import com.example.listingsapp_tripitaca.presentation.viewModel.ListingDetailsViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import com.prolificinteractive.materialcalendarview.*
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.ZoneId
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class ListingsDetails : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityListingsDetailsBinding
    private lateinit var property: ListingsDto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListingsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.google_maps) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.arrow.setOnClickListener {
            onBackPressed()
        }

        val viewModel: ListingDetailsViewModel =
            ViewModelProvider(this)[ListingDetailsViewModel::class.java]
        val propertyId = intent.getStringExtra("property_id")
        property = propertyId?.let { viewModel.getListingItemById(it) }!!
        getPropertyDetails(property)

        val dateStrings: List<String>? = propertyId?.let {
            viewModel.getListingItemById(it)?.bookedDates
                ?: emptyList()
        }
        val calendarView: MaterialCalendarView = binding.calendarView

        val dateObjects = mutableListOf<Date>()
        val simpleDateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())

        if (dateStrings != null) {
            for (dateString in dateStrings) {
                try {
                    val date = simpleDateFormat.parse(dateString)
                    date?.let {
                        dateObjects.add(it)
                    }
                } catch (exception: ParseException) {
                    exception.printStackTrace()
                }
            }
        } else {
            Log.d("Confirm", "DataStrings is null")
        }

        val selectedLocalDates = dateObjects.map { date ->
            date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        }

        for (localDate in selectedLocalDates) {
            val calenderDay =
                CalendarDay.from(localDate.year, localDate.monthValue - 1, localDate.dayOfMonth)
            calendarView.setDateSelected(calenderDay, true)
        }

        val jsonContents = readJsonContents(this, "listings.json")
        if (jsonContents != null) {
            val items = Gson().fromJson(jsonContents, Array<ListingsDto>::class.java).toList()
//            binding.recyclerView2.setHasFixedSize(true)
//            binding.recyclerView2.layoutManager =
//                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//            binding.recyclerView2.adapter = DatesAdapter(items, this)

            binding.recyclerView1.setHasFixedSize(true)
            binding.recyclerView1.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            binding.recyclerView1.adapter = AmenitiesAdapter(items, this)
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
        }
    }

    private fun readJsonContents(context: Context, fileName: String): String? {
        return try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            String(buffer, Charsets.UTF_8)
        } catch (exception: Exception) {
            exception.printStackTrace()
            null
        }
    }

    private fun getPropertyDetails(property: ListingsDto) {

        binding.propertyName.text = property.name
        binding.statusValue.text = property.status
        binding.typeValue.text = property.type
        binding.uniqueTypeValue.text = property.uniqueType
        binding.spaceValue.text = property.space
        binding.ratingValue.text = property.rating.toString()
        binding.checkOutValue.text = property.rules.checkOut
        binding.checkInValue.text = property.rules.checkIn
        binding.bookingsValue.text = property.bookings.toString()

        val url = property.photos[2]
        Picasso.with(this@ListingsDetails).load(url).error(R.drawable.home).into(binding.extraImage)


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val location = property.location.lat.let {
            property.location.lng.let { it1 ->
                LatLng(
                    it,
                    it1
                )
            }
        }

        location.let {
            MarkerOptions()
                .position(it)
                .title(property.location.name)
        }.let {
            mMap.addMarker(
                it
            )
        }

        location.let { CameraUpdateFactory.newLatLngZoom(it, 12f) }.let { mMap.moveCamera(it) }
    }
}