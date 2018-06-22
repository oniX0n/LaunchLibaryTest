package information

import jsonUtility.JsonFromUrl
import org.json.JSONObject
import java.text.DecimalFormat
import java.text.NumberFormat
import java.time.Duration
import java.time.Instant


class Launch constructor(id : Int) {

    private var jsonMasterObject: JSONObject

    init {
        val jsonCompleteObject = JsonFromUrl.jsonObjectFromUrl("https://launchlibrary.net/1.4/launch/$id")
        val jsonCompleteArray = jsonCompleteObject.getJSONArray("launches")
        jsonMasterObject = JSONObject(jsonCompleteArray[0].toString())
    }



    val name = jsonMasterObject.getString("name")

    val id = jsonMasterObject.getInt("id")

    val timeNet: Instant = Instant.ofEpochSecond(
            jsonMasterObject.getInt("netstamp").toLong()
    )

    val timeWindowStart: Instant = Instant.ofEpochSecond(
            jsonMasterObject.getInt("wsstamp").toLong()
    )

    val timeWindowsEnd: Instant = Instant.ofEpochSecond(
            jsonMasterObject.getInt("westamp").toLong()
    )

    val countdown = Countdown(timeNet)



    class Countdown constructor(private val launchInstant: Instant){

        private fun duration(): Duration{
            return Duration.between(Instant.now(), launchInstant)
        }

        fun hours(): Int {
            return duration().toHours().toInt()
        }

        fun minutes(): Int {
            return (duration().toMinutes() - duration().toHours() * 60).toInt()
        }

        fun seconds(): Int {
            return (duration().seconds - duration().toMinutes() * 60).toInt()
        }

        fun string(): String {
            val formatter: NumberFormat = DecimalFormat("00")
            val returnHours = formatter.format(hours())
            val returnMinutes = formatter.format(minutes())
            val returnSeconds = formatter.format(seconds())
            return ("$returnHours : $returnMinutes : $returnSeconds")
        }
    }
}

