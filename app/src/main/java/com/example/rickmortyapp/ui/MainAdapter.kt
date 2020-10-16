package com.example.rickmortyapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickmortyapp.R
import com.example.rickmortyapp.data.model.Character
import com.example.rickmortyapp.data.model.base.BaseViewHolder
import kotlinx.android.synthetic.main.character_row.view.*

class MainAdapter(
    private val context: Context,
    private val charactersList: List<Character>,
    private val itemClickListener: OnCharacterClickListener
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnCharacterClickListener {
        fun onCharacterClick(character: Character)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return CharacterViewHolder(
            LayoutInflater.from(context).inflate(R.layout.character_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CharacterViewHolder -> holder.bind(charactersList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    inner class CharacterViewHolder(itemView: View) : BaseViewHolder<Character>(itemView) {
        override fun bind(item: Character, position: Int) {
            Glide.with(context).load(item.image).into(itemView.img_character)
            itemView.setOnClickListener {
                itemClickListener.onCharacterClick(item)
            }
        }
    }
}