package com.shoppi.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shoppi.app.ui.util.logD
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        bottomNavigationView.itemIconTintList = null

        val navController = supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            //내부 호스트에서 네비게이션 컨트롤러를 가져옵니다.
            bottomNavigationView.setupWithNavController(it)
        }

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