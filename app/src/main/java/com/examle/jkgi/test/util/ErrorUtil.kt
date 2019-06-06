package com.examle.jkgi.test.util

import com.examle.api.util.error.ErrorCode
import com.examle.api.util.error.Own
import com.examle.api.util.error.RetrofitException

object ErrorUtil {

    @JvmStatic
    fun networkDisabled(throwable: Throwable): Boolean {
        return throwable is RetrofitException && throwable.own == Own.NETWORK &&
                throwable.httpErrorCode == ErrorCode.NO_INTERNET
    }
}