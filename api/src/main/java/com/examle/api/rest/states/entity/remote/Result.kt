package com.examle.api.rest.states.entity.remote

import com.google.gson.annotations.SerializedName

data class Result (
		@SerializedName("id") val id : Int,
		@SerializedName("country") val country : String,
		@SerializedName("name") val name : String,
		@SerializedName("abbr") val abbr : String,
		@SerializedName("area") val area : String,
		@SerializedName("largest_city") val largestCity : String?,
		@SerializedName("capital") val capital : String
)