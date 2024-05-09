package org.d3if3046.mopro1.budar.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3046.mopro1.budar.model.Budar

@Database(entities = [Budar::class], version = 1, exportSchema = false)
abstract class BudarDb : RoomDatabase() {
    abstract  val dao : BudarDao
    companion object {
        @Volatile
        private var INSTANCE: BudarDb? = null
        fun getInstance(context: Context): BudarDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BudarDb::class.java,
                        "budar.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}