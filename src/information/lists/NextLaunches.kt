package information.lists

import jsonUtility.JsonFromUrl
import org.json.JSONObject
import java.util.*

class NextLaunches constructor(number: Int){
    init {
        val jsonSourceObject = JsonFromUrl.jsonObjectFromUrl("https://launchlibrary.net/1.4/launch/next/$number")
        val jsonSourceArray = jsonSourceObject.getJSONArray("launches")
        val idArray = Array(number, {
            i -> JSONObject(jsonSourceArray[i].toString()).getInt("id")
        })
        println(Arrays.toString(idArray))
    }
}