package com.example.taehong.payzee;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class tableNumber extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_number);
        TextView yo = (TextView)findViewById(R.id.paynowId);
        yo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tableNumber.this, receiptShit.class);
                startActivity(intent);
            }
        });
    }

}
