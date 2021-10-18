package com.najed.bugapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import androidx.core.text.HtmlCompat.fromHtml

class PostActivity : AppCompatActivity() {

    lateinit var postTitleTextView: TextView
    lateinit var postAuthorTextView: TextView
    lateinit var postContentTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        postTitleTextView = findViewById(R.id.post_title_tv)
        postAuthorTextView = findViewById(R.id.post_author_tv)
        postContentTextView = findViewById(R.id.post_content_tv)
        postTitleTextView.text = intent.getStringExtra("title")
        postAuthorTextView.text = intent.getStringExtra("author")
        postContentTextView.text = fromHtml(intent.getStringExtra("content")!!, FROM_HTML_MODE_COMPACT)
    }
}