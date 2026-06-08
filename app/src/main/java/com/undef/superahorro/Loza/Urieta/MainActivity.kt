package com.undef.superahorro.Loza.Urieta

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.undef.superahorro.Loza.Urieta.data.repository.SuperAhorroRepository
import com.undef.superahorro.Loza.Urieta.navigation.NavGraph
import com.undef.superahorro.ui.AppSettings
import com.undef.superahorro.ui.theme.SuperAhorroTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // Inicializamos el repositorio único de datos
        val repository = SuperAhorroRepository()

        setContent {
            // Modo oscuro reactivo al toggle de Settings
            SuperAhorroTheme(darkTheme = AppSettings.darkMode) {

                // Idioma reactivo al toggle de Settings
                val targetLocale = if (AppSettings.useEnglish) Locale("en") else Locale("es")
                val baseConfig = LocalConfiguration.current
                val baseContext = LocalContext.current

                val newConfig = remember(targetLocale, baseConfig) {
                    Configuration(baseConfig).apply {
                        setLocale(targetLocale)
                    }
                }
                val newContext = remember(newConfig) {
                    baseContext.createConfigurationContext(newConfig)
                }

                CompositionLocalProvider(
                    LocalConfiguration provides newConfig,
                    LocalContext provides newContext
                ) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        val navController = rememberNavController()

                        // Levantamos la navegación pasándole el repositorio
                        NavGraph(
                            navController = navController,
                            repository = repository
                        )
                    }
                }
            }
        }
    }
}