package com.example.comundefsuperahorro.ui.theme.screens

class HomeScreen {

    package com.undef.superahorro.ui.screens

    import androidx.compose.foundation.layout.*
    import androidx.compose.material3.*
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.NavController

    @Composable
    fun HomeScreen(navController: NavController) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text("Home", fontSize = 24.sp)

            Button(onClick = { navController.navigate("nueva_compra") }) {
                Text("Nueva Compra")
            }

            Button(onClick = { navController.navigate("lista_compras") }) {
                Text("Ver Compras")
            }
        }
    }
}