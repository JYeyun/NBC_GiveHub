package com.example.nbc_givehub

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MainPageAdapter(val context: Context, val itemList: ArrayList<MainPageItem>) : BaseAdapter() {
    override fun getCount(): Int = itemList.size

    override fun getItem(position: Int): Any {
        return itemList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.mainpage_item, null)

        val itemName = view.findViewById<TextView>(R.id.item_name)
        val itemContents = view.findViewById<TextView>(R.id.item_contents)


        val item = itemList[position]
        itemName.text = item.postTitle
        itemContents.text = item.postSummary

        return view
    }
}