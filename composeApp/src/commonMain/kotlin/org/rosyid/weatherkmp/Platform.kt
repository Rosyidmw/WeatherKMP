package org.rosyid.weatherkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform