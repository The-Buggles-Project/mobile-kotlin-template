package org.buggles.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform