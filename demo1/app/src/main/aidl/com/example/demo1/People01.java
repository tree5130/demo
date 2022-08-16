package com.example.demo1;

import android.os.Parcel;
import android.os.Parcelable;

public class People01 implements Parcelable {
    public int sno;
    public String name;

    protected People01(Parcel in){
        sno = in.readInt();
        name = in.readString();
    }

    public static final Creator<People01> CREATOR = new Creator<People01>() {
        @Override
        public People01 createFromParcel(Parcel in) {
            return new People01(in);
        }

        @Override
        public People01[] newArray(int size) {
            return new People01[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(sno);
        parcel.writeString(name);
    }
}
