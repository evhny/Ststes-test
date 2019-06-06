package com.examle.api.util.error

class RetrofitException(
        @Own val own: Int,
        val url: String? = null,
        val httpErrorCode: Int,
        val erorBody: Any? = null,
        throwable: Throwable? = null) : RuntimeException(throwable?.message, throwable) {

    companion object {

        @JvmStatic
        fun networkError(throwable: Throwable?,
                         @ErrorCode code: Int): RetrofitException {
            return RetrofitException(
                    own = Own.NETWORK,
                    httpErrorCode = code,
                    throwable = throwable
            )
        }
    }
}