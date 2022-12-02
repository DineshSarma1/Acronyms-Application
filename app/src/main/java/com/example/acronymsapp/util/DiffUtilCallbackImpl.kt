package com.example.acronymsapp.util

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallbackImpl<FullForm> (private val oldList: List<FullForm>, private val newList: List<FullForm>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

}