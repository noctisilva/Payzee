package com.example.taehong.payzee;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

public class ConfirmPage extends Activity {
    confirmAsync strCheck;
    TextView t;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_page);
        Button yo = (Button)findViewById(R.id.refreshButton);
    }
    public void refreshButton(View view) throws IOException, JSONException {
        strCheck = new confirmAsync(this);
        strCheck.execute();
    }

    public void updateButtonState(Boolean a){
        t = (TextView)findViewById(R.id.titleOfScreen);
        b = (Button)findViewById(R.id.refreshButton);
        if(a){
            t.setText("Your table number is 1337!");
            b.setText("Next!");
            if(b.getText().equals("Next!")){
                Intent intent = new Intent(ConfirmPage.this, tableNumber.class);
                startActivity(intent);
            }
        }else{
            t.setText("Your table number is 1337!  Please wait!");
        }
    }

}
