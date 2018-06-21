package utility

import java.text.SimpleDateFormat
import java.util.*

class DateAndTime {
    companion object {
        fun stringToCalendaryyyyMMddTHHmmssZ(inputString: String): Calendar {
            var dateString = inputString.replace("T", "")
            dateString = dateString.replace("Z", "")

            val format = SimpleDateFormat("yyyyMMddHHmmss")
            val calendar = GregorianCalendar(Locale.ENGLISH)
            calendar.time = format.parse(dateString)
            return calendar
        }
    }
}