package com.example.taehong.payzee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by TaeHong on 11/8/2015.
 */
public class JsonStuff {
    public static void jsonP2() throws IOException, JSONException {
        JSONObject obj = new JSONObject(httpGet.httpGet("http://dmartin.org:8024/atms/v1/atm?Format=JSON&PageOffset=0&PageLength=10"));
        JSONObject temp = obj.getJSONObject("Atms");
        //System.out.println(temp);
        String yo = temp.toString();
        JSONObject obj2 = new JSONObject(yo);
        //System.out.println(obj);
        JSONArray array2 = obj2.getJSONArray("Atm");
        String yo2 = array2.toString().replaceAll("\\[", "").replaceAll("\\]","");
        //String yo2 = array2.toString();
        //System.out.println(yo2);
        JSONObject obj3 = new JSONObject(yo2);
        System.out.println(obj3);
        for(int i = 0; i < 9;i++) {
            JSONObject hello = array2.getJSONObject(i);
            System.out.println("\n");
            System.out.println("Name of " + i + " is: " + getDistance(hello));
            System.out.println("Distance of " + i + " is: " + getName(hello));
        }
    }
    public static String getDistance(JSONObject curr) throws JSONException{
        String str = "";
        JSONObject array3 = curr.getJSONObject("Location");
        String yo3 = array3.toString().replaceAll("\\[", "").replaceAll("\\]","");
        JSONObject obj4= new JSONObject(yo3);
        str = obj4.getString("Distance");
        return str;
    }

    public static String getName(JSONObject curr) throws JSONException{
        String str = "";
        JSONObject array3 = curr.getJSONObject("Location");
        String yo3 = array3.toString().replaceAll("\\[", "").replaceAll("\\]","");
        JSONObject obj4= new JSONObject(yo3);
        str = obj4.getString("Name");
        return str;
    }

    public static String jsonP23() throws IOException, JSONException{
        URL url = new URL("http://mastercard.digitalathlete.xyz/api/orders/3");
        httpGet newReq = new httpGet();
        JSONObject obj = new JSONObject(newReq.convertStreamToString(newReq.downloadUrl(url)));
        return obj.getString("state").toString();
    }
    public static void postToServer(){
        String line;
        StringBuffer jsonString = new StringBuffer();
        try {
            URL url = new URL("http://mastercard.digitalathlete.xyz/api/orders/3");
            //escape the double quotes in json string
            String payload="{\"cc\": 5555555555554444,\"cvc\": 123,\"expMonth\": 8,\"expYear\": 16}";
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            writer.write(payload);
            writer.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            connection.disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() + " " + e.getLocalizedMessage());
        }
    }
    protected void postTo()
    {
        HttpURLConnection connection;
        OutputStreamWriter request = null;
        String parameters = "{\"cc\": 5555555555554444,\"cvc\": 123,\"expMonth\": 8,\"expYear\": 16}";
        try
        {
            URL url = new URL("http://mastercard.digitalathlete.xyz/api/orders/3");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestMethod("POST");

            request = new OutputStreamWriter(connection.getOutputStream());
            request.write(parameters);
            request.flush();
            request.close();

        }
        catch(IOException e)
        {
            // Error
        }
    }
}
