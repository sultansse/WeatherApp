import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TodayDatabaseDao {

    @Insert
    suspend fun insert(today: TodayEntity)

    @Update
    suspend fun update(today: TodayEntity)

    @Query("SELECT * from today_hourly_temp_table WHERE uid = :key")
    suspend fun get(key: Long): TodayEntity?

    @Query("DELETE FROM today_hourly_temp_table")
    suspend fun clear()

    @Query("SELECT * FROM today_hourly_temp_table ORDER BY uid DESC")
    fun getAllTodays(): LiveData<List<TodayEntity>>

    @Query("SELECT * FROM today_hourly_temp_table ORDER BY uid DESC LIMIT 1")
    suspend fun getToday(): TodayEntity?
}
