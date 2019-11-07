package com.example.recyclerview.model.network

import com.example.recyclerview.model.network.UrlConstants.baseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    private fun retrofitInstance(): Retrofit{

        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getRetrofitInstance(): RetrofitClient {

        return retrofitInstance().create(RetrofitClient::class.java)
    }
}