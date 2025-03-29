package navigation
import cafe.adriel.voyager.navigator.Navigator
import androidx.compose.runtime.Composable
import ui.LoginScreen

@Composable
fun AppNavigation() {
    Navigator(LoginScreen(() => {})) // Ruta inicial
}

