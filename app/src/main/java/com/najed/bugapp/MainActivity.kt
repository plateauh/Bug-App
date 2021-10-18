package com.najed.bugapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.najed.bugapp.model.Feed
import com.najed.bugapp.model.entry.Entry
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit
    lateinit var call: Call<Feed?>
    private val BASE_URL = "https://www.reddit.com/r/"

    lateinit var posts: ArrayList<Entry>
    lateinit var postsRecyclerView: RecyclerView
    lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleTextView = findViewById(R.id.feed_title)
        buildRetrofitObject()
        postsRecyclerView = findViewById(R.id.posts_rv)
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        setData()

    }

    private fun buildRetrofitObject() {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        call = retrofit.create(FeedAPIInterface::class.java).feed!!
    }

    private fun setData() {
        call!!.enqueue(object : Callback<Feed?> {
            override fun onResponse(call: Call<Feed?>, response: Response<Feed?>) {
                val responseBody = response.body()!!
                titleTextView.text = responseBody.title
                posts = responseBody.entries!!
                postsRecyclerView.adapter = Adapter(this@MainActivity, posts)
            }
            override fun onFailure(call: Call<Feed?>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}