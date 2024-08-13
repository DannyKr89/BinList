package com.dk.binlist.data.retrofit

import com.dk.binlist.data.model.CardDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{bin}")
    suspend fun loadBin(
        @Path("bin") bin: String
    ): CardDto
}