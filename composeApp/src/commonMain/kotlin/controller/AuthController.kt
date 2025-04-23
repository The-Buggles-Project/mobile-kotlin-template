package controller

import network.AuthService
import network.LogInCredentials

class AuthController {
    private val authService = AuthService()

    suspend fun onLogin(username: String, password: String): String? {
        val response = authService.LogIn(LogInCredentials(username, password))
        return if(response.status.value == 200) {
            null;
        } else {
            "An error has been occurred meanwhile login";
        }
    }
}