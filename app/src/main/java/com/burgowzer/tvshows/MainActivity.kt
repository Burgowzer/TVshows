package com.burgowzer.tvshows

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import io.realm.Realm
import io.realm.RealmObject
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var requestQueue:RequestQueue
    lateinit var _realm:Realm
    val url:String = "http://jsonplaceholder.typicode.com/todos"
    lateinit var _list: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _realm = Realm.getDefaultInstance()

        recyclerView.adapter = CardViewAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)

        requestQueue = Volley.newRequestQueue(this)

        famousButton.setOnClickListener {

            UpdateListOfTitles(url)

        }
    }

    fun UpdateListOfTitles(url:String){

        val request = JsonArrayRequest(Request.Method.GET,url,null, { ObjectList:JSONArray ->

            val _titleList = ArrayList<String>()
            for (taskIndex in 0 until ObjectList.length()){
                val singleObject = ObjectList.getJSONObject(taskIndex)
                _titleList.add(singleObject.getString("title"))
                var stringBuilder = StringBuilder()
                stringBuilder.append(_titleList[taskIndex])
                textView.text=stringBuilder

            }
        },
            { Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT) })



        requestQueue.add(request)

        val intent = Intent(this,CardViewAdapter::class.java)
        intent.putExtra("list",_list)




    }



}