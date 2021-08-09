package com.aprouxdev.seeder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aprouxdev.seeder.helpers.DatabaseDriverFactory
import com.aprouxdev.seeder.services.initializeDatabase

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initializeDatabase(DatabaseDriverFactory(applicationContext))
    }
}