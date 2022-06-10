package com.linus.test;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class IFaceData implements Parcelable {
    public Intent intent;
    public IFaceData(Intent intent){
        this.intent = intent;
    }
    protected IFaceData(Parcel in) {
        intent = in.readParcelable(Intent.class.getClassLoader());
    }

    public static final Creator<IFaceData> CREATOR = new Creator<IFaceData>() {
        @Override
        public IFaceData createFromParcel(Parcel in) {
            return new IFaceData(in);
        }

        @Override
        public IFaceData[] newArray(int size) {
            return new IFaceData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(intent, flags);
    }
}
