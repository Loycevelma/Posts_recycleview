package com.example.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView



class PostlistRVAdapter(var postList: List<Post>,var context: Context):RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_view_post,parent,false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost=postList.get(position)
        holder.tvUserId.text=currentPost.UserId.toString()
        holder.tvId.text=currentPost.Id.toString()
        holder.tvTitle.text=currentPost.title
        holder.tvBody.text=currentPost.body


    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvUserId=itemView.findViewById<TextView>(R.id.tvUserId)
    var tvId=itemView.findViewById<TextView>(R.id.tvId)
    var tvTitle=itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
    var cvPosts=itemView.findViewById<TextView>(R.id.cvPosts)
    var rvPost=itemView.findViewById<TextView>(R.id.rvPost)

}