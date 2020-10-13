package org.example;


import org.json.*;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Get {
    /**
     * the same as GetAudio.java
     */
    static void GetAudio(String key) throws IOException {
        String path = "data\\" + key.toLowerCase() + ".mp3";
        File file = new File(path);
        if (file.createNewFile()) {
            System.out.println("getting data from internet");
            String url = "https://ssl.gstatic.com/dictionary/static/sounds/20180430/"
                    + key.toLowerCase()
                    + "--_us_1.mp3";
            URLConnection conn = new URL(url).openConnection();
            InputStream is = conn.getInputStream();

            OutputStream outstream = new FileOutputStream(file);
            byte[] buffer = new byte[4096];
            int len;
            while ((len = is.read(buffer)) > 0) {
                outstream.write(buffer, 0, len);
            }
            outstream.close();
        } else {
            System.out.println("loading local data");
        }
    }

    /**
     * return data of a word form oxford API, but not in a good condition
     */
    static Word GetWord(String key) throws IOException {
        Word result = new Word(key);
        URL url = new URL("https://od-api.oxforddictionaries.com/api/v2/entries/en-us/" + key.toLowerCase());
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.setRequestProperty("Accept", "application/json");
        urlConnection.setRequestProperty("app_id", "6f4039de");
        urlConnection.setRequestProperty("app_key", "09fbc20330a75d5cd4e39d8ab90f5a81");
        Scanner s = new Scanner(new InputStreamReader(urlConnection.getInputStream())).useDelimiter("\\A");
        String string = s.hasNext() ? s.next() : "";
        System.out.println(string);
        org.json.JSONObject x = new org.json.JSONObject(string);
        //  String pro = ((JSONArray)((JSONObject)((JSONArray)x.get("results")).getJSONObject(0)).get("lexicalEntries")).getJSONObject(0).get("entries").
        result.set_content(x.get("results").toString());
        return result;
    }

    public static void main(String[] args) throws IOException {
        Word x = Get.GetWord("word");
        System.out.println(x);
    }

}
