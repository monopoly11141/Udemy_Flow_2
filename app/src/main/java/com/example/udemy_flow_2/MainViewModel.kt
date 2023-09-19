package com.example.udemy_flow_2

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val indexFlow = flow<Int> {
        for(i in 1..100) {
            emit(i)
            delay(1_000L)
        }
    }

    init {
        backPressureDemo()
    }

    private fun backPressureDemo() {
        val indexFlowOne = flow<Int> {
            for(i in 1..10) {
                Log.i("MYTAG", "Produced : $i")
                emit(i)
                delay(1_000L)
            }
        }


        viewModelScope.launch {
            indexFlowOne.collect {
                delay(2_000L)
                Log.i("MYTAG", "Consumed : $it")
            }
        }
    }


}