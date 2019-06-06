package com.examle.api.rest.states

import com.examle.api.rest.states.entity.remote.Response
import retrofit2.http.GET
import rx.Observable

interface StatesService {

    @GET("state/get/USA/all")
    fun getStates(): Observable<Response>

}