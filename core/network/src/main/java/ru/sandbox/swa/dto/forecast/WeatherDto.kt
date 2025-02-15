import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDto(
    @Json(name = "clouds")
    val clouds: CloudsDto,
    @Json(name = "dt")
    val dateTimeMs: Long,
    @Json(name = "dt_txt")
    val date: String,
    @Json(name = "main")
    val commonInfo: CommonInfoDto,
    @Json(name = "rain")
    val rain: RainDto?,
    @Json(name = "wind")
    val wind: WindDto
)