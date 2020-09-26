package com.burgowzer.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var requestQueue:RequestQueue
    val url:String = "http://jsonplaceholder.typicode.com/todos"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = CardViewAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)

        requestQueue = Volley.newRequestQueue(this)

        famousButton.setOnClickListener {

            UpdateListOfTitles(url)

        }
    }

    fun UpdateListOfTitles(url:String){

        val request = JsonArrayRequest(Request.Method.GET,url,null, { ObjectList:JSONArray ->

            val _titleList = mutableListOf<JSONObject>()
            for (taskIndex in 0 until ObjectList.length()){
                val singleObject = ObjectList.getJSONObject(taskIndex)
                _titleList.add(singleObject)

        }
        },
            { Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT) })

        requestQueue.add(request)


    }



}