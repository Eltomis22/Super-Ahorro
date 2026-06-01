package com.undef.superahorro.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.undef.superahorro.R
import com.undef.superahorro.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistorialComprasScreen(
    navController: NavHostController,
    viewModel: HistorialComprasViewModel = viewModel() // Inyectamos el ViewModel de Compose
) {

    // Filtros traídos desde strings.xml para que respeten el idioma activo
    val filtros = listOf(
        stringResource(R.string.filter_all),
        stringResource(R.string.filter_this_month),
        stringResource(R.string.filter_last_month),
        "Carrefour",
        "Coto"
    )
    var filtroActivo by remember { mutableStateOf(filtros.first()) }

    // AHORA: El ViewModel orquesta y nos da los datos ya procesados desde el Repository
    val agrupadas by viewModel.comprasAgrupadas

    val mesesArray = stringArrayResource(R.array.month_names)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.history_title)) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Filled.FilterList, null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Chips de filtros
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(filtros) { filtro ->
                    AssistChip(
                        onClick = { filtroActivo = filtro },
                        label = { Text(filtro) },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = if (filtroActivo == filtro)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.surface,
                            labelColor = if (filtroActivo == filtro)
                                MaterialTheme.colorScheme.onPrimary
                            else
                                MaterialTheme.colorScheme.onSurface
                        )
                    )
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                agrupadas.forEach { (mes, compras) ->
                    item {
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = formatMes(mes, mesesArray),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    items(compras, key = { it.id }) { compra ->
                        CompraResumenCard(
                            compra = compra,
                            onClick = {
                                navController.navigate(Screen.DetalleCompra.createRoute(compra.id))
                            }
                        )
                    }
                }
            }
        }
    }
}
private fun formatMes(yyyyMm: String, meses: Array<String>): String {
    val partes = yyyyMm.split("-")
    val mesIndex = partes.getOrNull(1)?.toIntOrNull()?.minus(1) ?: return yyyyMm
    val mes = meses.getOrNull(mesIndex) ?: return yyyyMm
    return "$mes ${partes[0]}"
}
