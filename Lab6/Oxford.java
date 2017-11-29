import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public class Oxford {
    public static Oxford instance;
    private Oxford() {}
    public static Oxford getInstance() {
        if (instance == null) {
            synchronized (Oxford.class) {
                if (instance == null)
                    instance = new Oxford();}}
        return instance;}
    public String dictionary(String word) {
        JSONParser parser = new JSONParser();
        String ret = "404";
        try {
            final String result = getRequest(buildURL(word));
            final Object parse = parser.parse(result);
            ret = (String) ((JSONArray) ((JSONObject) ((JSONArray) ((JSONObject) ((JSONArray) ((JSONObject) ((JSONArray) ((JSONObject) ((JSONArray) ((JSONObject) parse).get("results")).get(0)).get("lexicalEntries")).get(0)).get("entries")).get(0)).get("senses")).get(0)).get("definitions")).get(0);
        } catch (Exception e) {
            System.out.println(e);}
        return ret;}
    private String buildURL(final String word) {
        final String language = "en";
        final String word_id = word.toLowerCase(); //word id is case sensitive and lowercase is required
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word_id;}
    private String getRequest(String link) {
        final String app_id = "2f0d7a3a";
        final String app_key = "5215f3131a55b7cdabb65c4193c63d49";
        try {
            URL url = new URL(link);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("app_id", app_id);
            urlConnection.setRequestProperty("app_key", app_key);
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");}
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();}}}
