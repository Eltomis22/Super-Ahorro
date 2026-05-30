package com.example.comundefsuperahorro.ui.theme.screens

class NuevaCompraScreen {

    package com.undef.superahorro.ui.screens

    import androidx.compose.foundation.layout.*
    import androidx.compose.material3.*
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.NavController

    @Composable
    fun NuevaCompraScreen(navController: NavController) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text("Nueva Compra", fontSize = 24.sp)

            OutlinedTextField(value = "", onValueChange = {}, label = { Text("Supermercado") })
            OutlinedTextField(value = "", onValueChange = {}, label = { Text("Total") })

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate("home") }) {
                Text("Guardar (Mock)")
            }
        }
    }
}