package com.example.taehong.payzee;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class lastPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);
    }

    public void goHome(View view) {
        Intent intent = new Intent(lastPage.this, rootPage.class);
        startActivity(intent);
    }
}


