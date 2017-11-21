package com.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatButton
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<AppCompatButton>(R.id.btnListView).setOnClickListener {
            startActivity(Intent(applicationContext, ListViewActivity::class.java))
        }

        findViewById<AppCompatButton>(R.id.btnRecView).setOnClickListener {
            startActivity(Intent(applicationContext, RecyclerViewActivity::class.java))
        }
    }
}
