package org.rosyid.weatherkmp.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Rain(
    val `1h`: Double?
)