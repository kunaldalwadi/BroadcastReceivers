package com.example.tof;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextInfo;
    BroadcastReceiver receiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter("android.os.action.TOF_SENSOR_EVENT_ACTION");
        intentFilter.addAction(Intent.CATEGORY_DEFAULT);
        receiver = new CustomReceiver();


//        intent.putExtra(ATSDeviceManager.EXTRA_DETECTION_TYPE);
//        intent.putExtra(ATSDeviceManager.EXTRA_DETECTION_DISTANCE,
//                data);


        mTextInfo = findViewById(R.id.tv_display_info);

    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(receiver, intentFilter);
       /* Intent intent = new Intent("action.TOF_SENSOR_EVENT_ACTION");
        sendBroadcast(intent);*/

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }
}
