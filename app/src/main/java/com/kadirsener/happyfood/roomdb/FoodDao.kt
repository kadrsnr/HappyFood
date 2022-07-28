package com.kadirsener.happyfood.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food : Food)

    @Delete
    suspend fun deleteFood (food : Food)

    @Query("SELECT * FROM foods")
    fun observeFood (): LiveData<List<Food>>

}