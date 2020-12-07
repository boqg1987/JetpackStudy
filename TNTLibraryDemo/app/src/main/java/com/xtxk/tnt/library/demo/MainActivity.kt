package com.xtxk.tnt.library.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.startup.AppInitializer
import com.xtxk.tnt.library.startup.java.ActivityInitializer

//import com.xtxk.tnt.library.startup.kotlin.ActivityInitializer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startupInit()
        setContentView(R.layout.activity_main)
    }

    fun startupInit(){
        Log.e("MainActivity","startAppInitializer")
        AppInitializer.getInstance(this)
            .initializeComponent(ActivityInitializer::class.java)
        Log.e("MainActivity","endAppInitializer")
    }
}
