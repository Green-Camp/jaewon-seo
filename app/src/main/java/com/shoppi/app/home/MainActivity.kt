package com.shoppi.app.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shoppi.app.R
import com.shoppi.app.util.logD
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())
        logD("OnCreate")
    }

    override fun onStart() {
        super.onStart()
        logD("OnStart")
    }

    override fun onResume() {
        super.onResume()
        logD("OnResume")
    }

    override fun onStop() {
        super.onStop()
        logD("OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logD("OnDestroy")
    }

    override fun onPause() {
        super.onPause()
        logD("OnPause")
    }

    override fun onRestart() {
        super.onRestart()
        logD("OnRestart")
    }

}