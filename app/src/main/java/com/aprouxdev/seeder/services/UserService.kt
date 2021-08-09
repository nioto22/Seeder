package com.aprouxdev.seeder.services

import android.provider.ContactsContract
import com.aprouxdev.seeder.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/*
* Created by antoine on 09.08.21.
*/

internal sealed class LoginState {
    object none : LoginState()
    class logged(val user: User) : LoginState()
}

enum class UserState {
    FROM, TO, BOTH
}

internal class UserService {
    companion object {
        val instance = UserService()
    }

    private var _loginState: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.none)
    val loginState: StateFlow<LoginState> = _loginState


    fun loadUser() {
        val user = Database.userQueries.selectMe().executeAsOneOrNull()
        // Set UserState as state flow
        user?.let {
            _loginState.value = LoginState.logged(it)
        }
    }

    fun insertUser(user: User) {
        Database.userQueries.insertOrReplace(user)
    }
}