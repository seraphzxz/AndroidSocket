package com.example.seraphzxz.androidsocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.seraphzxz.androidsocket.network.SocketClient;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final String SERVER_IP = "192.168.199.210";
    public static final int SERVER_PORT = 9999;
    private Button connect, connectByJni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect = findViewById(R.id.main_btn_connect);
        connect.setOnClickListener(v->SocketClient.connect(SERVER_IP,SERVER_PORT,"hello server."));
        connectByJni = findViewById(R.id.main_btn_connectByJni);
        connectByJni.setOnClickListener(v->SocketClient.connectByJni(SERVER_IP,SERVER_PORT));
    }

}
