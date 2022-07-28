package com.kadirsener.happyfood.api

import com.kadirsener.happyfood.model.FoodResponse
import com.kadirsener.happyfood.util.Util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {
                    @GET("/v1/nutrition")
                    suspend fun foodSearch(
                        @Query("query")  searchQuery : String,
                        @Query("X-Api-Key ") apiKey : String = API_KEY
                    ) : Response<FoodResponse>

        }