package information.lists

import information.Launch
import jsonUtility.JsonFromUrl
import org.json.JSONObject

class NextLaunches constructor(number: Int){
    private val launchArray: Array<Launch>

    init {
        val jsonSourceObject = JsonFromUrl.jsonObjectFromUrl("https://launchlibrary.net/1.4/launch/next/$number")
        val jsonSourceArray = jsonSourceObject.getJSONArray("launches")
        val idArray = Array(number, {
            i -> JSONObject(jsonSourceArray[i].toString()).getInt("id")
        })

        launchArray = Array(number, {
            i -> Launch(idArray[i])
        })
    }
}