package com.example.comundefsuperahorro.ui.theme.screens

class LoginScreen {

    package com.undef.superahorro.ui.screens

    import androidx.compose.foundation.layout.*
    import androidx.compose.material3.*
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.NavController

    @Composable
    fun LoginScreen(navController: NavController) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text("Login", fontSize = 24.sp)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(value = "", onValueChange = {}, label = { Text("Email") })
            OutlinedTextField(value = "", onValueChange = {}, label = { Text("Password") })

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate("home") }) {
                Text("Ingresar")
            }
        }
    }
}