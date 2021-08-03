package com.example.mypost


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("posts")
    fun getPosts():Call<List<Post>>//IF THEIR IS NO SPECIFICATION OF DATA


    @GET ("posts/{id}")
    fun getPostId(@Path("id")postId:Int):Call<Post>//IF THEIR IS A SPECIFIC DATA REQUIRED


    @GET("post/{post_id}/comments")
    fun getComments(@Path("post_id")id:Int):Call<List<Comments>>

}