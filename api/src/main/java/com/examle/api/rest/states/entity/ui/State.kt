package com.examle.api.rest.states.entity.ui

import java.io.Serializable

data class State(
        var id: Int,
        val country: String,
        val name: String,
        val abbr: String,
        val area: String,
        val largestCity: String?,
        val capital: String
): Serializable