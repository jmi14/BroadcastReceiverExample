package com.example.intagpc.broadcastreceiverexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etMessage;
    private Button btnSendMessage;
    private String typedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        buttonListener();
    }

    private void buttonListener() {

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMessage();
                sendMessageBroadcast(typedMessage);
            }
        });
    }

    private void sendMessageBroadcast(String message) {

        Intent intent = new Intent(MainActivity.this, MessageReceiver.class);
        intent.setAction("com.example.intagpc.broadcastreceiverexample.SEND_MESSAGE");
        intent.putExtra("message", message);
        sendBroadcast(intent);

    }

    private void initWidgets() {

        etMessage = (EditText) findViewById(R.id.etMessage);
        btnSendMessage = (Button) findViewById(R.id.btnSendMessage);
    }

    public void getMessage() {

        typedMessage = etMessage.getText().toString();
    }
}
