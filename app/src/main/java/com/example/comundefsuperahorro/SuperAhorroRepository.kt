package com.example.comundefsuperahorro

import com.undef.superahorro.data.MockData
import com.undef.superahorro.data.model.Compra
import com.undef.superahorro.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SuperAhorroRepository {

    fun getUsuarioActual(): User = MockData.usuarioActual
    fun getSupermercados(): List<String> = MockData.supermercados
    fun getGastoPorSupermercado(): List<Pair<String, Double>> = MockData.gastoPorSupermercado
    fun getGastoMensual(): List<Pair<String, Double>> = MockData.gastoMensual

    // Agregamos 'suspend' y simulamos el hilo de Background (IO) que usarán Room/Retrofit
    suspend fun getCompras(): List<Compra> = withContext(Dispatchers.IO) {
        MockData.compras
    }

    suspend fun getCompraById(id: Int): Compra? = withContext(Dispatchers.IO) {
        MockData.compras.find { it.id == id }
    }
}