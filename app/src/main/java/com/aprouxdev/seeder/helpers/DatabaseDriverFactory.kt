package com.aprouxdev.seeder.helpers

import android.content.Context
import com.aprouxdev.seeder.SeederDatabase
import com.aprouxdev.seeder.User
import com.aprouxdev.seeder.services.Database
import com.squareup.sqldelight.ColumnAdapter
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

/*
* Created by antoine on 09.08.21.
*/

class DatabaseDriverFactory(private val context: Context) {
    fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(SeederDatabase.Schema, context, "seeder.db")
    }
}