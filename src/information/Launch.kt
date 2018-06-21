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

    private val name = jsonMasterObject.getString("name")
    private val id = jsonMasterObject.getInt("id")
    private val timeNet: Instant = Instant.ofEpochSecond(
            jsonMasterObject.getInt("netstamp").toLong()
    )
    private val timeWindowStart: Instant = Instant.ofEpochSecond(
            jsonMasterObject.getInt("wsstamp").toLong()
    )
    private val timeWindowsEnd: Instant = Instant.ofEpochSecond(
            jsonMasterObject.getInt("westamp").toLong()
    )


    fun getTimeNet(): Instant {
        return timeNet
    }

    fun getTimeWindowStart(): Instant {
        return  timeWindowStart
    }

    fun getTimeWindowEnd(): Instant {
        return timeWindowsEnd
    }

    fun getName(): String {
        return name
    }

    fun getId(): Int {
        return id
    }

    fun getTimeUntilDuration(): Duration{
        val timeNow = Instant.now()
        return Duration.between(timeNow, timeNet)
    }

    fun getTimeUntilString(): String{
        val duration = getTimeUntilDuration()
        val days = (duration.toDays()).toString()
        val hours = (duration.toHours() - duration.toDays() * 24).toString()
        val minutes = (duration.toMinutes() - duration.toHours() * 60).toString()
        val seconds = (duration.toMillis() / 1000 - duration.toMinutes() * 60).toString()
        return "$days : $hours : $minutes : $seconds "
    }
}