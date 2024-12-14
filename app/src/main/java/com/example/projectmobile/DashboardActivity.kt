package com.example.projectmobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectmobile.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding
    var imageList=ArrayList<Int>()
    var titleList=ArrayList<String>()
    var descList=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username= intent.getStringExtra("name").toString()
        val email= intent.getStringExtra("email").toString()
        val gender= intent.getStringExtra("gender").toString()
        val country= intent.getStringExtra("country").toString()
        val city= intent.getStringExtra("city").toString()

        binding.overallInfo.text="Welcome $username\n "+"Email: $email\n"+"Gender: $gender\n"+"Country: $country\n"+"City: $city\n"


        val recyclerView: RecyclerView = binding.recy
        recyclerView.layoutManager= LinearLayoutManager(this@DashboardActivity)


        imageList.add(R.drawable.bike)
        imageList.add(R.drawable.sign)
        imageList.add(R.drawable.bgi)

        titleList.add("Bike")
        titleList.add("Sign")
        titleList.add("Bgi")

        descList.add("This is bike")
        descList.add("This is sign")
        descList.add("This is bgi")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}