package information

import jsonUtility.JsonFromUrl
import org.json.JSONObject
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
    }
}

