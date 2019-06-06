package com.examle.api

import android.content.Context
import com.examle.api.rest.ApiServer
import com.examle.api.util.NetworkUtil
import com.examle.api.util.converter.convert
import com.examle.api.util.error.ErrorCode
import com.examle.api.util.error.RetrofitException
import rx.Observable
import javax.inject.Inject

class ApiManager @Inject constructor(
        private val apiServer: ApiServer,
        private val appContext: Context) {

    private fun getApiServer(): Observable<ApiServer> = checkNetwork()

    private fun checkNetwork() = Observable.fromCallable {
        if (!NetworkUtil.isNetworkAvailable(appContext)) {
            throw RetrofitException.networkError(null, ErrorCode.NO_INTERNET)
        }
        apiServer
    }

    fun getStates() = getApiServer()
            .flatMap { server -> server.statesService.getStates() }
            .map { it.restResponse.result.convert() }
}
