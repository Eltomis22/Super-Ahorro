package com.example.comundefsuperahorro.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.undef.superahorro.model.Producto
class DetalleCompraScreen {

    @Composable
    fun DetalleCompraScreen(navController: NavController) {

        val productos = listOf(
            Producto(1, "Leche", 1200.0, 2),
            Producto(2, "Pan", 800.0, 1)
        )

        Column(modifier = Modifier.padding(16.dp)) {

            Text("Detalle Compra", fontSize = 24.sp)

            productos.forEach {
                Text("${it.nombre} - ${it.cantidad} x $${it.precio}")
            }
        }
    }
}