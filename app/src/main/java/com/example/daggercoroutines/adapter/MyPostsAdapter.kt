package com.example.daggercoroutines.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daggercoroutines.R
import com.example.daggercoroutines.model.PostsItem

class MyPostsAdapter (private val postList: List<PostsItem>):
    RecyclerView.Adapter<MyPostsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val id: TextView
        val body: TextView

        init {
            title = view.findViewById(R.id.titlePosts)
            id = view.findViewById(R.id.idPosts)
            body = view.findViewById(R.id.idBody)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = postList[position].title
        holder.id.text = postList[position].id.toString()
        holder.body.text = postList[position].body

    }

    override fun getItemCount() = postList.size

}