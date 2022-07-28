package com.kadirsener.happyfood.model

import com.google.gson.annotations.SerializedName

data class FoodResult(
            @SerializedName("sugar_g")
            val sugar : Double?,
            @SerializedName("fiber_g")
            val fiber : Double?,
            @SerializedName("serving_size_g")
            val servingSize : Int?,
            @SerializedName("sodium_mg")
            val sodium : Double?,
            val name : String?,
            @SerializedName("potassium_mg")
            val potassium : Double?,
            @SerializedName("fat_saturated_g")
            val fat_saturated : Double?,
            @SerializedName("fat_total_g")
            val fatTotal : Double?,
            val calories : Double?,
            @SerializedName("cholesterol_mg")
            val cholesterol : Double?,
            @SerializedName("protein_g")
            val protein : Double?,
            @SerializedName("carbohydrates_total_g")
            val carbohydratesTotal : Double?


)
