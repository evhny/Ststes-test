package com.examle.api.rest.states.entity.remote

import com.google.gson.annotations.SerializedName


data class RestResponse (
		@SerializedName("messages") val messages : List<String>,
		@SerializedName("result") val result : List<Result>
)