data class HotelDetailResponse(
    val code: Int = 0,
    val isSuccess: Boolean = false,
    val message: String = "",
    val result: List<Result> = listOf()
)