package org.rosyid.weatherkmp.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Clouds(
    val all: Int?
)