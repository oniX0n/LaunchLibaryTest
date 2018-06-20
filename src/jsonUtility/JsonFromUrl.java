package jsonUtility;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class JsonFromUrl {
    private static String readUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) buffer.append(chars, 0, read);
            return buffer.toString();
        }
    }

    static public JSONObject jsonObjectFromUrl(String urlString){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(readUrl(urlString));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
