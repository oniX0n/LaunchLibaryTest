package utility

import java.text.SimpleDateFormat
import java.util.*

class DateAndTime {
    companion object {
        fun stringToDateyyyyMMddTHHmmssZ(inputString: String): Date {
            var dateString = inputString.replace("T", "")
            dateString = dateString.replace("Z", "")

            val format = SimpleDateFormat("yyyyMMddHHmmss")
            format.timeZone = TimeZone.getTimeZone("Europe/Amsterdam") //TODO: Get the timezones right
            return format.parse(dateString)
        }
    }
}