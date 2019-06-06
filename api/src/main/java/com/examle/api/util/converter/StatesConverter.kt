package com.examle.api.util.converter

import com.examle.api.rest.states.entity.remote.Result
import com.examle.api.rest.states.entity.ui.State

fun Result.convert(): State =
        State(id = id,
                abbr = abbr,
                area = area,
                capital = capital,
                country = country,
                largestCity = largestCity ?: "",
                name = name
        )

fun List<Result>.convert() = map { it.convert() }