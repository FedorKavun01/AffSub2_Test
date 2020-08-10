package com.example.affsub2_test.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.example.affsub2_test.R
import com.example.affsub2_test.ViewModel.ProfileAdapter
import com.example.affsub2_test.ViewModel.ProfileViewModel

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    lateinit var profileLV: ListView
    lateinit var adapter: ProfileAdapter
    lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ProfileViewModel()
        adapter = ProfileAdapter(this, viewModel.getProfilesList())
        profileLV = findViewById(R.id.LV)
        profileLV.adapter = adapter
        profileLV.onItemClickListener = this

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var intent = Intent(this, ProfileActivity::class.java)
        var bundle: Bundle = Bundle()
        intent.putExtra("id", id)
        startActivity(intent)
    }
}