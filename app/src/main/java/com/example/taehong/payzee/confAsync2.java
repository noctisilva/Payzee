package com.example.taehong.payzee;

import android.os.AsyncTask;
import android.view.View;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by TaeHong on 11/8/2015.
 */
public class confAsync2 extends AsyncTask{
    receiptShit activity;
    String checker;
    String open;
    JsonStuff newJson;
    String nJson;
    public confAsync2(receiptShit a){
        this.activity = (receiptShit) a;
        newJson = new JsonStuff();
    };

    @Override
    protected Object doInBackground(Object[] params) {
        newJson.postToServer();
        return null;
    }
    @Override
    protected void onPostExecute(Object o){

    }
}
