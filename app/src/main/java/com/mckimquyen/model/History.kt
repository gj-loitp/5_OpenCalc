package com.mckimquyen.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class History(
    @SerializedName("calculation") val calculation: String,
    @SerializedName("result") val result: String,
    @SerializedName("time") val time: String
) : Serializable
