package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId=0
    lateinit var tvuserId: TextView
    lateinit var tvid: TextView
    lateinit var tvtitle: TextView
    lateinit var tvbody: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_post)

        postId=intent.getIntExtra("POST_ID",0)
        tvuserId=findViewById(R.id.tvuserId)
        tvid=findViewById(R.id.tvid)
        tvtitle=findViewById(R.id.tvtitle)
        tvbody=findViewById(R.id.tvbody)
        getPostById()

    }

    fun getPostById(){
        var apiclient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiclient.getPostId(postId)

        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if(response.isSuccessful){
                    var post=response.body()
                    tvuserId.text=post?.userid
                    tvid.text=post?.id
                    tvtitle.text=post?.title
                    tvbody.text=post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()
            }
        })


    }
}

