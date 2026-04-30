package com.example.comundefsuperahorro.ui.theme.screens
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.undef.superahorro.model.Compra
class ListaComprasScreen {

    @Composable
    fun ListaComprasScreen(navController: NavController) {

        val compras = listOf(
            Compra(1, "Carrefour", 15000.0, "30/04/2026"),
            Compra(2, "Disco", 8200.0, "29/04/2026")
        )

        LazyColumn {
            items(compras) { compra ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("detalle_compra")
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(compra.supermercado)
                        Text("Total: $${compra.total}")
                        Text(compra.fecha)
                    }
                }
            }
        }
    }
}