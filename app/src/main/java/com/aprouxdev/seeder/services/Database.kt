package com.aprouxdev.seeder.services

import com.aprouxdev.seeder.*
import com.aprouxdev.seeder.helpers.DatabaseDriverFactory
import com.squareup.sqldelight.ColumnAdapter
import com.squareup.sqldelight.EnumColumnAdapter
import java.sql.Driver

/*
* Created by antoine on 09.08.21.
*/

// Our database called where we want
lateinit var Database: SeederDatabase

// Call at start of the app
fun initializeDatabase(databaseDriverFactory: DatabaseDriverFactory) {

    // Adapter for a list of object
    val listOfStringsAdapter = object : ColumnAdapter<List<String>, String> {
        override fun decode(databaseValue: String) =
            if (databaseValue.isEmpty()) {
                listOf()
            } else {
                databaseValue.split(",")
            }
        override fun encode(value: List<String>) = value.joinToString(separator = ",")
    }

    // The database with parameters auto generated in Database.invoke function
    Database = SeederDatabase(
        driver = databaseDriverFactory.createDriver(),
        UserAdapter = User.Adapter(
            couplesAdapter = listOfStringsAdapter,
            userStateAdapter = EnumColumnAdapter()
        ),
        AddOnAdapter = AddOn.Adapter(
            addOnStateAdapter = EnumColumnAdapter(),
            addOnTypeAdapter = EnumColumnAdapter()
        ),
        CountDownAdapter = CountDown.Adapter(
            cdStateAdapter = EnumColumnAdapter()
        ),
        EventAdapter = Event.Adapter(
            addOnListAdapter = listOfStringsAdapter
        ),
        CoupleAdapter = Couple.Adapter(
            eventsAdapter= listOfStringsAdapter,
            coupleStateAdapter = EnumColumnAdapter()
        )
    )
    UserService.instance.loadUser()
}


