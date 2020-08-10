package com.example.affsub2_test.ViewModel

import android.app.Service
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.affsub2_test.Model.Profile
import com.example.affsub2_test.R

class ProfileAdapter(val ctx: Context, val list: ArrayList<Profile>) : BaseAdapter() {

    var layoutInflater: LayoutInflater = ctx.getSystemService(Service.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        var item: Profile = getItem(position) as Profile

        if (view == null) {
            view = layoutInflater.inflate(R.layout.item, parent, false)
            view as View
        }

        view.findViewById<ImageView>(R.id.itemImage).setImageBitmap(item.picture)
        view.findViewById<TextView>(R.id.itemName).setText(item.name)
        return view
    }

    override fun getItem(position: Int): Any {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}