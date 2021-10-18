package com.najed.bugapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.najed.bugapp.databinding.PostRowBinding
import com.najed.bugapp.model.entry.Entry

class Adapter(private val context: Context, private val postsList: ArrayList<Entry>):
    RecyclerView.Adapter<Adapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: PostRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(PostRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val post = postsList[position]
        holder.binding.apply {
            titleTv.text = post.title
            authorTv.text = "by: ${post.author!!.name!!.removePrefix("/u/")}"
            publishTv.text = "published: ${post.published}"
            postCard.setOnClickListener {
                val intent = Intent(context, PostActivity::class.java)
                intent.putExtra("title", post.title)
                intent.putExtra("author", post.author!!.name)
                intent.putExtra("content", post.content)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = postsList.size
}