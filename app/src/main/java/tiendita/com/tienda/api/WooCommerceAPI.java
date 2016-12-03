package tiendita.com.tienda.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;;


public class WooCommerceAPI {

    private String baseURL;
    private static String tag = "WooAPI";

    private APIRequestTask requestTask;

    public WooCommerceAPI(Context context) {
        // Fetch preferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        // Fetch values from preferences storage
        baseURL = preferences.getString("base_url", "");
        String consumer_key = preferences.getString("consumer_key", "");
        String consumer_secret = preferences.getString("consumer_secret", "");
        // Creates new request object with given parameters
        requestTask = new APIRequestTask(context, consumer_key, consumer_secret);
    }

    private JSONObject fetch(String request) throws ExecutionException, InterruptedException, JSONException {
        StringBuilder sb = new StringBuilder(baseURL);
        return new JSONObject(requestTask.execute(new String[]{sb.append(request).toString()}).get());
    }
}
