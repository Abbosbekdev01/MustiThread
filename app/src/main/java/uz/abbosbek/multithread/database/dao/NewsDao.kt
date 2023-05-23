package uz.abbosbek.multithread.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Flowable
import uz.abbosbek.multithread.database.entity.NewsEntity

@Dao
interface NewsDao {

    @Insert
    fun addNews(newsEntity: NewsEntity)

    @Query("select * from newsentity")
    fun getAllNews():Flowable<List<NewsEntity>>
}