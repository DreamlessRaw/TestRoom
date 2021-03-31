package com.example.testroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var mainAdapter: MainAdapter
    private lateinit var todoDao: TodoDao
    private var count_add = 0
    private var count_del = 0
    private val TAG: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        rcv_data.layoutManager = linearLayoutManager

        todoDao = TodoDatabase.getDatabase(this).todoDao()
        mainAdapter = MainAdapter(this, mutableListOf())
        rcv_data.adapter = mainAdapter


        btn_add.setOnClickListener {
            thread {
                count_add++
                todoDao.insert(Todo(title = "测试-$count_add", content = "内容-$count_add"))
                getData()
            }
        }

        btn_del.setOnClickListener {
            thread {
                count_del++
                todoDao.deleteById(count_del)
                getData()
            }
        }
        getData()
    }

    private fun getData() {
        thread {
            val data = todoDao.select()
            runOnUiThread { mainAdapter.notifyData(data) }
        }
    }
}