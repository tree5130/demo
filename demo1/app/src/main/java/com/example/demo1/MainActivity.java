package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Myservice";
    IMyAidlInterfaceo1 iMyAidlInterfaceo1;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iMyAidlInterfaceo1 = IMyAidlInterfaceo1.Stub.asInterface(iBinder);
            try {
                List<People01> list = iMyAidlInterfaceo1.getPeople();
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < list.size(); i ++ ) {
                    s.append(list.get(i).name + '\n');
                }
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(s.toString());


            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            iMyAidlInterfaceo1 = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreat");
        setContentView(R.layout.activity_main);

        Intent intentService = new Intent();
        intentService.setPackage("com.example.demo1");
        intentService.setAction("com.example.demo1.Myservice");
        MainActivity.this.bindService(intentService, serviceConnection, BIND_AUTO_CREATE);
    }


}