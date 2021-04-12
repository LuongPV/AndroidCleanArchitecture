package com.pv.cleanarchitecture.data.mappers

enum class APILanguage(private val value: String) {
    EN("en"),
    EN_US("en-US"),
    VI("vi"),
    VI_VN("vi-VN");

    override fun toString(): String {
        return value
    }

}