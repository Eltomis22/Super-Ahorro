package com.example.comundefsuperahorro.ui.screens.productos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comundefsuperahorro.Producto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductosViewModel : ViewModel() {

    private val repository = SuperAhorroRepository()//agregamos instancias del repositorio
    private val _uiState = MutableStateFlow(ProductosUiState())
    val uiState: StateFlow<ProductosUiState> = _uiState.asStateFlow()

    init {
        cargarProductos()
    }

    fun cargarProductos() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                // TODO: Cuando metan Room, acá buscarán los productos de la Base de Datos
                // Por ahora simulamos una lista vacía o mock:
                val listaMock = emptyList<Producto>()

                _uiState.update { it.copy(isLoading = false, listaDeProductos = listaMock) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    // Acá van a ir agregando funciones como: fun agregarProducto(producto: Producto) { ... }
}