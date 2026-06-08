package com.undef.superahorro.Loza.Urieta.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

// Importamos el repositorio único
import com.undef.superahorro.Loza.Urieta.data.repository.SuperAhorroRepository

// IMPORTANTE: Estos imports apuntan a las pantallas que están guardadas en la carpeta de abajo
import com.undef.superahorro.Loza.Urieta.ui.screens.home.HomeViewModel
import com.undef.superahorro.Loza.Urieta.ui.screens.estadisticas.EstadisticasViewModel
import com.undef.superahorro.Loza.Urieta.ui.screens.listadocompras.ListadoComprasViewModel
import com.undef.superahorro.Loza.Urieta.ui.screens.detallecompra.DetalleCompraViewModel
import com.undef.superahorro.Loza.Urieta.ui.screens.home.HomeScreen
import com.undef.superahorro.Loza.Urieta.ui.screens.estadisticas.EstadisticasScreen
import com.undef.superahorro.Loza.Urieta.ui.screens.listadocompras.ListadoComprasScreen
import com.undef.superahorro.Loza.Urieta.ui.screens.detallecompra.DetalleCompraScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    repository: SuperAhorroRepository
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        // 🏠 1. HOME
        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return HomeViewModel(repository) as T
                    }
                }
            )
            HomeScreen(navController = navController, viewModel = homeViewModel)
        }

        // 📊 2. ESTADÍSTICAS
        composable(Screen.Estadisticas.route) {
            val estadisticasViewModel: EstadisticasViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return EstadisticasViewModel(repository) as T
                    }
                }
            )
            EstadisticasScreen(navController = navController, viewModel = estadisticasViewModel)
        }

        // 📜 3. HISTORIAL
        composable(Screen.HistorialCompras.route) {
            val listadoViewModel: ListadoComprasViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return ListadoComprasViewModel(repository) as T
                    }
                }
            )
            ListadoComprasScreen(navController = navController, viewModel = listadoViewModel)
        }

        // 🔍 4. DETALLE DE COMPRA
        composable(
            route = Screen.DetalleCompra.route,
            arguments = listOf(navArgument("compraId") { type = NavType.IntType })
        ) { backStackEntry ->
            val compraId = backStackEntry.arguments?.getInt("compraId") ?: 0

            val detalleViewModel: DetalleCompraViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return DetalleCompraViewModel(repository) as T
                    }
                }
            )
            DetalleCompraScreen(
                compraId = compraId,
                navController = navController,
                viewModel = detalleViewModel
            )
        }
    }
}}}