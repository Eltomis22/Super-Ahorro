package com.undef.superahorro.ui.screens

import androidx.lifecycle.ViewModel
import com.example.comundefsuperahorro.SuperAhorroRepository
import com.undef.superahorro.data.model.Compra

class HistorialComprasViewModel : ViewModel() {

    // El ViewModel tiene la instancia del repositorio
    private val repository = SuperAhorroRepository()

    // El ViewModel realiza la orquestación/procesamiento de los datos
    fun getComprasAgrupadas(): Map<String, List<Compra>> {
        val comprasOrdenadas = repository.getCompras().sortedByDescending { it.fecha }
        return comprasOrdenadas.groupBy { it.fecha.substring(0, 7) }
    }
}