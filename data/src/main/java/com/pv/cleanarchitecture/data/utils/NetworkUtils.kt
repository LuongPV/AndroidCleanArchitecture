package com.pv.cleanarchitecture.data.utils

import com.pv.cleanarchitecture.data.exceptions.ConnectionTimeoutException
import com.pv.cleanarchitecture.data.exceptions.LoginExpiredException
import com.pv.cleanarchitecture.data.exceptions.NoInternetException
import com.pv.cleanarchitecture.data.exceptions.ServerIssueException
import io.reactivex.rxjava3.core.SingleTransformer
import retrofit2.HttpException
import java.net.HttpURLConnection
import java.net.SocketException
import java.net.SocketTimeoutException

fun <T> networkException(): SingleTransformer<T, T> {
    return SingleTransformer { single ->
        single.doOnError {
            when {
                it is SocketException -> throw NoInternetException()
                it is SocketTimeoutException -> throw ConnectionTimeoutException()
                it is HttpException && it.code() == HttpURLConnection.HTTP_INTERNAL_ERROR -> throw ServerIssueException()
                it is HttpException && it.code() == HttpURLConnection.HTTP_FORBIDDEN -> throw LoginExpiredException()
                else -> throw it
            }
        }
    }
}