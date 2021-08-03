package com.example.mypost

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentslistRVAdapter (var comments: List<Post>,var context: Context):
    RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_view_post,parent,false)
        return CommentsViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment=comments.get(position)
        holder.cvComments.text=currentComment.body
        holder.tvuserid.text=currentComment.UserId.toString()
        holder.tvid.text=currentComment.Id.toString()
        holder.tvbody.text=currentComment.body
        holder.tvtitle.text=currentComment.title



    }

    override fun getItemCount(): Int {
        return comments.size
    }
}

    class CommentsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvuserid=itemView.findViewById<TextView>(R.id.tvUserId)
        var tvid=itemView.findViewById<TextView>(R.id.tvid)
        var tvtitle=itemView.findViewById<TextView>(R.id.tvtitle)
        var tvbody=itemView.findViewById<TextView>(R.id.tvbody)
        var cvComments=itemView.findViewById<TextView>(R.id.cvComments)
        var rvComments=itemView.findViewById<TextView>(R.id.rvComments)

    }
}