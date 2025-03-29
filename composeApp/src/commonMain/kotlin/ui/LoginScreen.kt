package ui
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen

@Composable
fun LoginScreen(): Screen {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Iniciar Sesión", style = MaterialTheme.typography.h4)

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") }
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation()
        )

        Button(
            onClick = {
                isLoading = true
                errorMessage = null
                onLogin(username, password)
            },
            enabled = username.isNotEmpty() && password.isNotEmpty()
        ) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(24.dp))
            } else {
                Text("Ingresar")
            }
        }

        errorMessage?.let {
            Text(text = it, color = MaterialTheme.colors.error)
        }
    }
}

