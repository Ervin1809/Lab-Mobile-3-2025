package com.example.instagram;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Highlight implements Parcelable {
//    private String username;
    private int highlight;

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

    public int getHighlight() {
        return highlight;
    }

    public void setHighlight(int highlight) {
        this.highlight = highlight;
    }

    public Highlight(int highlight) {
//        this.username = username;
        this.highlight = highlight;
    }



    protected Highlight(Parcel in) {
//        username = in.readString();
        highlight = in.readInt();
    }

    public static final Creator<Highlight> CREATOR = new Creator<Highlight>() {
        @Override
        public Highlight createFromParcel(Parcel in) {
            return new Highlight(in);
        }

        @Override
        public Highlight[] newArray(int size) {
            return new Highlight[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
//        dest.writeString(username);
        dest.writeInt(highlight);
    }
}
