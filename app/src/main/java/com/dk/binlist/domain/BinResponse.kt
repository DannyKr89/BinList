package com.dk.binlist.domain

sealed class BinResponse<out T> {
    data class Success<T>(val data: T) : BinResponse<T>()
    data class Error(val error: Throwable) : BinResponse<Nothing>()
    data class Loading(val progress: Long? = null) : BinResponse<Nothing>()
}