package com.najed.bugapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.najed.bugapp.databinding.PostRowBinding
import com.najed.bugapp.model.entry.Entry

class Adapter(private val postsList: ArrayList<Entry>): RecyclerView.Adapter<Adapter.ItemViewHolder>() {
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
        }
    }

    override fun getItemCount() = postsList.size
}