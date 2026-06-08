package com.undef.superahorro.Loza.Urieta.ui.screens.productos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ProductosRoute(
    viewModel: ProductosViewModel = viewModel()
) {
    // Consumo del estado respetando el ciclo de vida de la pantalla
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    ProductosContent(state = state)
}

@Composable
fun ProductosContent(
    state: ProductosUiState
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            state.isLoading -> CircularProgressIndicator()
            state.error != null -> Text(text = "Error: ${state.error}")
            state.listaDeProductos.isEmpty() -> Text(text = "No hay productos. ¡Agrega uno!")
            else -> {
                // Acá va el diseño original que ya tengan de su lista
                Text(text = "Productos listos para mostrar: ${state.listaDeProductos.size}")
            }
        }
    }
}