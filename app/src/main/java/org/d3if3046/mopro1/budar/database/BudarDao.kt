
package org.d3if3046.mopro1.budar.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3046.mopro1.budar.model.Budar

@Dao
interface BudarDao {
    @Insert
    suspend fun insert(budar: Budar)
    @Update
    suspend fun update(budar: Budar )
    @Query("SELECT * FROM budar ORDER BY judul DESC")
    fun getBudar(): Flow<List<Budar>>
    @Query("SELECT * FROM budar WHERE judul = :judul")
    suspend fun getBudarById(judul: String): Budar?
    @Query("DELETE FROM budar WHERE judul = :judul")
    suspend fun deleteById(judul: String)


}
