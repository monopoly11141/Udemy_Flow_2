package com.example.udemy_flow_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.udemy_flow_2.ui.theme.Udemy_Flow_2Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val mainViewModel = viewModel<MainViewModel>()
            val currentIndex = mainViewModel.indexFlow.collectAsState(initial = 1).value
            Udemy_Flow_2Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DisplayIndex(currentIndex)
                }
            }
        }
    }
}

@Composable
fun DisplayIndex(index: Int) {
    Text(text = "$index")
}