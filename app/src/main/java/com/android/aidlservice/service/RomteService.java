package com.android.aidlservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.android.aidlservice.IRomteAidlInterface;
import com.android.aidlservice.bean.Person;

public class RomteService extends Service {

    private static final String TAG = "RmoteService";

    private Person mPerson;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mPerson = new Person("Tangkc", "24");
        return new RomteBinder();
    }

    class RomteBinder extends IRomteAidlInterface.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getPersonUserName() throws RemoteException {

            return  mPerson.getmUserName();
        }

        @Override
        public String getPersonUserAge() throws RemoteException {

            return mPerson.getmUserAge();
        }

    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

}
