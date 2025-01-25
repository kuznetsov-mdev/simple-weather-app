import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RainDto(
    @Json(name = "3h")
    val probability: Double
)