package network

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.Serializable

@Serializable
data class CreateAccountData(val username: String, val password: String, val email: String,val firstName: String, val lastName: String)

@Serializable
data class LogInCredentials(val username: String, val password: String)

interface ForgeryResponse {
    val message: String
    val key: String
}

class AuthService {
    private val client = HttpClientProvider.client;
    private val baseUrl = HttpClientProvider.BASE_URL;

    suspend fun LogIn(data: LogInCredentials): HttpResponse {
        val forgeryKey = client.get("$baseUrl/forgery").body<ForgeryResponse>().key
        return client.post("$baseUrl/login") {
            contentType(ContentType.Application.Json)
            setBody(data)
            headers {
                append("Forgery-Key", forgeryKey)
            }
        }.body()
    }

    suspend fun SignUp(data: CreateAccountData): HttpResponse {
        val forgeryKey = client.get("$baseUrl/forgery").body<ForgeryResponse>().key
        return client.post("$baseUrl/signup") {
            contentType(ContentType.Application.Json)
            setBody(data)
            headers {
                append("Forgery-Key", forgeryKey)
            }
        }
    }
}