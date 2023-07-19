package com.example.starwarscharacters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarscharacters.R
import com.example.starwarscharacters.databinding.RecyclerViewItemLayoutBinding

class Adapter(private var itemsList: List<AdapterItem>, private val addToFavorite: (Int) -> Boolean) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(val binding: RecyclerViewItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerViewItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            nameTV.text = itemsList[position].name
            subInfoTV.text = itemsList[position].subInfo
            addToFavBt.setOnClickListener {
                addToFavBt.setImageResource(if(addToFavorite(itemsList[position].id.toInt())) R.drawable.favorite_active_image else R.drawable.favorite_image)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}