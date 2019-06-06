package com.examle.api.rest.states.entity.remote

import com.google.gson.annotations.SerializedName

data class Response (
	@SerializedName("RestResponse") val restResponse : RestResponse
)