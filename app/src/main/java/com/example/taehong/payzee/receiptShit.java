package com.example.taehong.payzee;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class receiptShit extends Activity {

    confAsync2 strCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_shit);

    }
    public void post(View view) throws IOException, JSONException {
        strCheck = new confAsync2(this);
        strCheck.execute();
        Intent intent = new Intent(receiptShit.this, lastPage.class);
        startActivity(intent);
    }


}
