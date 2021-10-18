package com.najed.bugapp

import com.najed.bugapp.model.Feed
import retrofit2.Call
import retrofit2.http.GET

interface FeedAPIInterface {

    @get:GET("whatsthisbug/.rss")
    val feed: Call<Feed?>?

    companion object {
        const val BASE_URL = "https://www.reddit.com/r/"
    }

}