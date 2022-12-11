import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "today_hourly_temp_table")
data class TodayEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0L,

    @ColumnInfo(name = "temp")
    var temp: Int = -1,

    @ColumnInfo(name = "time")
    var time: Int = -1
)
