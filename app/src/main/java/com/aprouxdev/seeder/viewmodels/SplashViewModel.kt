package com.aprouxdev.seeder.viewmodels

import androidx.lifecycle.ViewModel
import com.aprouxdev.seeder.services.UserService
import com.aprouxdev.seeder.services.UserState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

/*
* Created by antoine on 09.08.21.
*/

class SplashViewModel: ViewModel() {

    // Effects
    sealed class Effect {
        object Login : Effect()
        object Main : Effect()
    }


}