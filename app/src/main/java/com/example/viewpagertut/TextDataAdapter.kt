package com.example.viewpagertut

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagertut.databinding.MainFragmentBinding

class TextDataAdapter(private val textList: List<TextData>) :
    RecyclerView.Adapter<TextDataAdapter.TextDataViewHolder> () {

        inner class TextDataViewHolder (private val binding : MainFragmentBinding)
            : RecyclerView.ViewHolder(binding.root){
                fun bindItem(textData: TextData ){
                    binding.iconIv.setImageResource(textData.photo)
                    binding.textView1.text = textData.skip
                    binding.textView2.text = textData.title
                    binding.textView3.text = textData.text


                }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextDataViewHolder {
        return TextDataViewHolder(
            MainFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TextDataViewHolder, position: Int) {
        holder.bindItem(textList[position])

    }

    override fun getItemCount(): Int {
        return textList.size

    }
}