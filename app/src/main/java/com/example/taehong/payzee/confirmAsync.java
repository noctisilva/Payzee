package com.example.taehong.payzee;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by TaeHong on 11/8/2015.
 */
public class confirmAsync extends AsyncTask{
    ConfirmPage activity;
    String checker;
    String open;
    JsonStuff newJson;
    String nJson;
    public confirmAsync(ConfirmPage a){this.activity = a;
    newJson = new JsonStuff();
    };

    @Override
    protected Object doInBackground(Object[] params) {
        try {
            nJson = newJson.jsonP23();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }



        return null;
    }
    @Override
    protected void onPostExecute(Object o){
        if(nJson.equals("open")){
            activity.updateButtonState(true);
        }else {
            activity.updateButtonState(false);
        }
    }
}
