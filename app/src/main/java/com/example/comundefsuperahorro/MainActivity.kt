package com.example.comundefsuperahorro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.comundefsuperahorro.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperAhorroApp()
        }
    }
}

@Composables
fun SuperAhorroApp() {
    val navController = rememberNavController()
    NavGraph(navController)
}
