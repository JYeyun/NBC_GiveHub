package com.example.nbc_givehub

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
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

        val userImage = view.findViewById<ImageView>(R.id.user_image)
        val userName = view.findViewById<TextView>(R.id.user_name)
        val postImage = view.findViewById<ImageView>(R.id.post_image_view)
        val postName = view.findViewById<TextView>(R.id.post_name)
        val postContents = view.findViewById<TextView>(R.id.post_contents)
        val postLike = view.findViewById<TextView>(R.id.like)

        val item = itemList[position]
        userImage.setImageResource(item.userImage)
        userName.text = item.userName
        postImage.setImageResource(item.postImage)
        postName.text = item.postTitle
        var deleteHtmlString = Html.fromHtml(item.postSummary).toString()
        postContents.text = deleteHtmlString
        postLike.text = item.like.toString()

        return view
    }
}