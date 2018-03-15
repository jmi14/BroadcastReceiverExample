package com.example.intagpc.broadcastreceiverexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowMessage extends AppCompatActivity {

    private TextView tvShowMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        tvShowMessage = (TextView) findViewById(R.id.tvShowMessage);
        String message = getIntent().getExtras().getString("message");
        tvShowMessage.setText(message);

    }
}
