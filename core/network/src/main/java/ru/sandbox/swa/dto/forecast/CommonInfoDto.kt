import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommonInfoDto(
    @Json(name = "feels_like")
    val feelsLike: Double,
    @Json(name = "humidity")
    val humidity: Int,
    @Json(name = "temp")
    val temperature: Double
)