package com.undef.superahorro.data

import com.undef.superahorro.data.model.Compra
import com.undef.superahorro.data.model.Producto
import com.undef.superahorro.data.model.User

object MockData {

    val usuarioActual = User(
        id = 1,
        nombre = "Tomas Losa",
        email = "tomas@undef.edu.ar"
    )

    val supermercados = listOf(
        "Carrefour",
        "Coto",
        "Día",
        "Jumbo",
        "La Anónima",
        "Vea",
        "Disco",
        "ChangoMas"
    )

    private val productosCompra1 = listOf(
        Producto(1, "7790070410016", "Leche La Serenísima", "Leche entera 1L", 2, 950.0),
        Producto(2, "7790580121204", "Pan Lactal Bimbo", "Pan lactal blanco 540g", 1, 1850.0),
        Producto(3, "7790520005014", "Aceite Natura", "Aceite girasol 1.5L", 1, 3200.0)
    )

    private val productosCompra2 = listOf(
        Producto(4, "7791001000034", "Yerba Taragüí", "Yerba mate 1kg", 1, 4500.0),
        Producto(5, "7790070401120", "Queso Cremoso", "Queso cremoso 500g", 1, 3800.0),
        Producto(6, "7791290001008", "Galletitas Oreo", "Galletitas chocolate 118g", 3, 1200.0)
    )

    private val productosCompra3 = listOf(
        Producto(7, "7790040502154", "Coca Cola", "Gaseosa 2.25L", 2, 2100.0),
        Producto(8, "7791540067519", "Detergente Magistral", "Detergente 750ml", 1, 1950.0)
    )

    val compras = listOf(
        Compra(
            id = 1,
            fecha = "2026-04-28",
            hora = "18:30",
            supermercado = "Carrefour",
            total = productosCompra1.sumOf { it.subtotal },
            productos = productosCompra1
        ),
        Compra(
            id = 2,
            fecha = "2026-04-22",
            hora = "11:15",
            supermercado = "Coto",
            total = productosCompra2.sumOf { it.subtotal },
            productos = productosCompra2
        ),
        Compra(
            id = 3,
            fecha = "2026-04-15",
            hora = "20:00",
            supermercado = "Día",
            total = productosCompra3.sumOf { it.subtotal },
            productos = productosCompra3
        ),
        Compra(
            id = 4,
            fecha = "2026-04-08",
            hora = "16:45",
            supermercado = "Jumbo",
            total = 12750.0
        ),
        Compra(
            id = 5,
            fecha = "2026-03-30",
            hora = "19:20",
            supermercado = "Carrefour",
            total = 8430.0
        )
    )

    /** Estadísticas precalculadas para la pantalla de gráficos. */
    val gastoMensual = listOf(
        "Nov" to 28500.0,
        "Dic" to 41200.0,
        "Ene" to 35800.0,
        "Feb" to 39400.0,
        "Mar" to 42100.0,
        "Abr" to 47350.0
    )

    val gastoPorSupermercado = listOf(
        "Carrefour" to 22600.0,
        "Coto" to 17500.0,
        "Día" to 8400.0,
        "Jumbo" to 12750.0
    )
}
