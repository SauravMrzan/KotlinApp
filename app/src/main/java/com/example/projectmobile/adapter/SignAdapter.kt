package com.example.projectmobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectmobile.R

class SignAdapter(
    val context: Context,
    val imageList: ArrayList<Int>,
    val titleList: ArrayList<String>,
    val descList: ArrayList<String>
):RecyclerView.Adapter<SignAdapter.SignViewHolder>(){
    class SignViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var image: ImageView =itemView.findViewById(R.id.bikepic)
        var title: TextView = itemView.findViewById(R.id.lblTitle)
        var desc: TextView = itemView.findViewById(R.id.lblDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SignViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.sample_sign,parent,false)
        return SignViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: SignViewHolder, position: Int) {
        holder.image.setImageResource((imageList[position]))
        holder.title.text = titleList[position]
        holder.desc.text= descList[position]
    }

}
