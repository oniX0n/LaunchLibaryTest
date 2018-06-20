package information

import jsonUtility.JsonFromUrl
import org.json.JSONObject
import utility.DateAndTime
import java.util.*

class Launch constructor(id : Int) {

    private var jsonMasterObject: JSONObject

    init {
        val jsonCompleteObject = JsonFromUrl.jsonObjectFromUrl("https://launchlibrary.net/1.4/launch/$id")
        val jsonCompleteArray = jsonCompleteObject.getJSONArray("launches")
        jsonMasterObject = JSONObject(jsonCompleteArray[0].toString())
    }

    private val name = jsonMasterObject.getString("name")
    private val id = jsonMasterObject.getInt("id")
    private val launchTime: Calendar = DateAndTime.stringToCalendaryyyyMMddTHHmmssZ(jsonMasterObject.getString("isonet"))

    fun getName(): String {
        return name
    }

    fun getLaunchTime(): Calendar {
        return launchTime
    }

    fun getId(): Int {
        return id
    }
}