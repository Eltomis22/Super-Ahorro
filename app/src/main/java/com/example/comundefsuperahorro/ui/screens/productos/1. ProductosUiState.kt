package com.undef.superahorro.Loza.Urieta.ui.screens.productos

// Asegurate de que este import coincida con la nueva ubicación de tu clase Producto
import com.undef.superahorro.Loza.Urieta.Producto

data class ProductosUiState(
    val isLoading: Boolean = false,
    val listaDeProductos: List<Producto> = emptyList(),
    val error: String? = null
)