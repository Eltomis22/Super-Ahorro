package com.example.comundefsuperahorro

import com.undef.superahorro.data.MockData
import com.undef.superahorro.data.model.Compra
import com.undef.superahorro.data.model.User

class SuperAhorroRepository {

    fun getUsuarioActual(): User {
        return MockData.usuarioActual
    }

    fun getSupermercados(): List<String> {
        return MockData.supermercados
    }

    fun getCompras(): List<Compra> {
        return MockData.compras
    }

    fun getCompraById(id: Int): Compra? {
        return MockData.compras.find { it.id == id }
    }

    fun getGastoMensual(): List<Pair<String, Double>> {
        return MockData.gastoMensual
    }

    fun getGastoPorSupermercado(): List<Pair<String, Double>> {
        return MockData.gastoPorSupermercado
    }
}