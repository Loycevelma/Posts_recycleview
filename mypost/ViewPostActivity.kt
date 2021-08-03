package com.example.mypost

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class ViewPostActivity : AppCompatActivity() {

    var postId=0
    lateinit var tvpostTitle:TextView
    lateinit var tvpostBody:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_post)

        postId=intent.getIntExtra("POST_ID",0)

        tvpostUserId=findViewById(R.id.tvPostUserId)
        tvpostId=findViewById(R.id.tvPostId)
        tvpostBody=findViewById(R.id.tvPostBody)
        tvpostBody=findViewById(R.id.tvPostBody)

        fetchPostById()


    }

    fun fetchPostById(){
        var apiclient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiclient.getPostId(postId)

        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if(response.isSuccessful){
                    var post=response.body()
                    tvpostTitle.text=post?.title
                    tvpostBody.text=post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })


    }
}