package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import ui.LoginScreen

@Serializable
object Home

@Serializable
object Login

val navController = rememberNavController()

@Composable
fun AppNavigation() {

}

