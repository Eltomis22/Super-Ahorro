package com.example.comundefsuperahorro.ui.screens.productos

// Asegurate de que este import coincida con la nueva ubicación de tu clase Producto
import com.example.comundefsuperahorro.Producto

data class ProductosUiState(
    val isLoading: Boolean = false,
    val listaDeProductos: List<Producto> = emptyList(),
    val error: String? = null
)