package com.examle.api.rest
import com.examle.api.rest.states.StatesService
import javax.inject.Inject

class ApiServer @Inject constructor(
        val statesService: StatesService)