package com.mohamed.myapplication.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mohamed.myapplication.R
import com.mohamed.myapplication.model.DataModel
import com.mohamed.myapplication.ui.main.adapter.PhotoAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private lateinit var photoAdapter: PhotoAdapter
    private var dataList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //initiate the grid  view
        //in this case I make row grid in a row
        //if you want to change that change the number

        recyclerView.layoutManager = GridLayoutManager(applicationContext, 4)
        photoAdapter = PhotoAdapter(applicationContext)
        recyclerView.adapter = photoAdapter

        //add data
        dataList.add(DataModel("Box #1", "Desc", R.color.blue))
        dataList.add(DataModel("Box #2", "Desc", R.color.blue))
        dataList.add(DataModel("Box #3", "Desc", R.color.blue))
        dataList.add(DataModel("Box #4", "Desc", R.color.blue))
        dataList.add(DataModel("Box #5", "Desc", R.color.blue))
        dataList.add(DataModel("Box #6", "Desc", R.color.blue))
        dataList.add(DataModel("Box #7", "Desc", R.color.blue))
        dataList.add(DataModel("Box #8", "Desc", R.color.blue))
        dataList.add(DataModel("Box #9", "Desc", R.color.blue))
        dataList.add(DataModel("Box #10", "Desc", R.color.blue))
        dataList.add(DataModel("Box #11", "Desc", R.color.blue))
        dataList.add(DataModel("Box #12", "Desc", R.color.blue))
        dataList.add(DataModel("Box #13", "Desc", R.color.blue))
        dataList.add(DataModel("Box #14", "Desc", R.color.blue))
        dataList.add(DataModel("Box #15", "Desc", R.color.blue))
        dataList.add(DataModel("Box #16", "Desc", R.color.blue))

        photoAdapter.setDataList(dataList)


    }
}