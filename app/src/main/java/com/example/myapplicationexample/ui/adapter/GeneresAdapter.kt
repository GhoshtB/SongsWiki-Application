package com.example.myapplicationexample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationexample.R
import com.example.myapplicationexample.databinding.RowGenresBinding
import com.example.myapplicationexample.model.Tag

class GeneresAdapter(val callback: Tag.() -> Unit) :
    RecyclerView.Adapter<GeneresAdapter.GeneresHolder>() {

    lateinit var binding: RowGenresBinding
    var tag: List<Tag> = arrayListOf()

    inner class GeneresHolder(binding: RowGenresBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tag: Tag) {
            binding.genreCard.setOnClickListener {
                callback(tag)
            }
            binding.setVariable(BR.tag, tag)
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneresHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_genres,
            parent,
            false
        )

        return GeneresHolder(binding)
    }

    override fun onBindViewHolder(holder: GeneresHolder, position: Int) {
        holder.bind(tag[position])
       /* holder.itemView.setOnClickListener {
            callback(tag[position])
        }*/
    }

    override fun getItemCount(): Int {
        return tag.size
    }
}