package com.example.myapplicationexample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationexample.BR
import com.example.myapplicationexample.R
import com.example.myapplicationexample.databinding.AlbumsRowBinding
import com.example.myapplicationexample.model.Details
import com.squareup.picasso.Picasso

class AlbumsAdapter(var details: List<Details> = arrayListOf(),val callback:Details.()->Unit) : RecyclerView.Adapter<AlbumsAdapter.AlbumsHolder>() {

    lateinit var binding: AlbumsRowBinding


    inner class AlbumsHolder(binding: AlbumsRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(details: Details) {
            if (details.image.isNullOrEmpty()) {
              binding.ivAlbum.setImageResource(R.drawable.ic_launcher_background)
            }else{
                Picasso.get().load(details.image).placeholder(R.drawable.ic_launcher_background)
                    .into(binding.ivAlbum)
            }
            binding.cvArtist.setOnClickListener {
                callback(details)
            }
            binding.setVariable(BR.detail, details)
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.albums_row,
            parent,
            false
        )

        return AlbumsHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumsHolder, position: Int) {
        holder.bind(details[position])
    }

    override fun getItemCount(): Int {
        return details.size
    }
}