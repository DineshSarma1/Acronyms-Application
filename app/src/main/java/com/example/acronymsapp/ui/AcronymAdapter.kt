package com.example.acronymsapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.acronymsapp.R
import com.example.acronymsapp.data.FullForm
import com.example.acronymsapp.databinding.ItemAcronymBinding

class AcronymAdapter(
    private val fullFormList: MutableList<FullForm> = mutableListOf()
) : RecyclerView.Adapter<AcronymAdapter.AcronymViewHolder>(){

    inner class AcronymViewHolder(private val binding: ItemAcronymBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(fullForm: FullForm) {
            binding.fullForm = fullForm
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: MutableList<FullForm>) {
        fullFormList.clear()
        fullFormList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcronymViewHolder {
        val binding = ItemAcronymBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_acronym, parent, false))
        return AcronymViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AcronymViewHolder, position: Int) {
        holder.apply {
            bind(fullFormList[position])
        }
    }

    override fun getItemCount(): Int = fullFormList.size
}