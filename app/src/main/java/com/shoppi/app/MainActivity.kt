package com.shoppi.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shoppi.app.Util.logD
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

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