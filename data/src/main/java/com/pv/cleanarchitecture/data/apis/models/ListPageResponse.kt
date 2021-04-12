package com.pv.cleanarchitecture.data.apis.models

import com.google.gson.annotations.SerializedName

data class ListPageResponse<EntityType>(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<EntityType>
)