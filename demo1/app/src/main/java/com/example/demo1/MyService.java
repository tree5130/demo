package com.example.demo1;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {
    private List<People01> peopleList = new ArrayList<People01>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) { // 构建的aidl的接口
        return new StubBinder();
    }
    public class StubBinder extends IMyAidlInterfaceo1.Stub {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public List<People01> getPeople() throws RemoteException {
            return peopleList;
        }

        @Override
        public void addPeople(People01 people) throws RemoteException {
            synchronized (peopleList) {
                if (!peopleList.contains(people)) {
                    peopleList.add(people);
                }
            }
        }
    }



}
