package uz.abbosbek.multithread.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.abbosbek.multithread.database.dao.NewsDao
import uz.abbosbek.multithread.database.entity.NewsEntity

@Database(entities = [NewsEntity::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun newsDao():NewsDao

    companion object{
        private var appDatabase:AppDatabase? = null

        fun getInstance(context: Context):AppDatabase{
            if (appDatabase == null){
                appDatabase = Room.databaseBuilder(context,AppDatabase::class.java, "my_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return appDatabase!!
        }
    }
}