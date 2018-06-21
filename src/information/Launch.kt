package information

import jsonUtility.JsonFromUrl
import org.json.JSONObject


class Launch constructor(id : Int) {

    private var jsonMasterObject: JSONObject

    init {
        val jsonCompleteObject = JsonFromUrl.jsonObjectFromUrl("https://launchlibrary.net/1.4/launch/$id")
        val jsonCompleteArray = jsonCompleteObject.getJSONArray("launches")
        jsonMasterObject = JSONObject(jsonCompleteArray[0].toString())
    }

    private val name = jsonMasterObject.getString("name")
    private val id = jsonMasterObject.getInt("id")

    fun getName(): String {
        return name
    }

    fun getId(): Int {
        return id
    }
}