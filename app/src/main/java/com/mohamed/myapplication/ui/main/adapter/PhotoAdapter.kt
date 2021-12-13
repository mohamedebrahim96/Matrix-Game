package com.mohamed.myapplication.ui.main.adapter

/**
 * Created by @mohamedebrahim96 on 13,December,2021
 * ShopiniWorld, Inc
 * ebrahimm131@gmail.com
 */

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.myapplication.R
import com.mohamed.myapplication.model.DataModel

class PhotoAdapter(var context: Context) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    var dataList = mutableListOf<DataModel>()

    var positions = arrayListOf<Int>()

    var counter = 1

    //val positionList: MutableList<Int> = mutableListOf()
    internal fun setDataList(dataList: MutableList<DataModel>) {
        this.dataList = dataList
    }

    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView

        init {
            image = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.title)
        }

    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.photo_layout, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = dataList[position]
        holder.image.setImageResource(data.image)
        holder.itemView.setOnClickListener {
            holder.image.setImageResource(R.color.red)
            holder.title.text = "Box #$counter"
            counter++
            dataList[position].apply {
                this.position = position
            }
            positions.add(position)

            if (positions.size >= 3) {
                notifyItemChanged(positions[positions.size - 2])
                notifyItemChanged(positions[positions.size - 3])
                //notifyItemChanged(positions[positions.size - 1])
            }
            Log.e("test", dataList.toString())
        }
        if (positions.size >= 3) {
            if (positions[positions.size - 2] == position) {
                holder.image.setImageResource(R.color.red)
                holder.title.text = "Box #${counter - 2}"
            } else if (positions[positions.size - 3] == position) {
                holder.image.setImageResource(R.color.blue)
                holder.title.text = "Box #${counter - 3}"
            }
        }
    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}