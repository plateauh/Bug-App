package com.najed.bugapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
                posts = response.body()!!.entries!!
                postsRecyclerView.adapter = Adapter(posts)
            }
            override fun onFailure(call: Call<Feed?>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}