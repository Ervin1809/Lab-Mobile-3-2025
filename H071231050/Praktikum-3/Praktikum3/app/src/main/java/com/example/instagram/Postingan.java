package com.example.instagram;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Postingan implements Parcelable {
    private int imagePorfil,imagePostingan, like,comments,share;
    private String name,caption;

    private Uri uri;

    public Postingan(int imagePorfil, int imagePostingan, int like, int comments, int share, String name, String caption) {
        this.imagePorfil = imagePorfil;
        this.imagePostingan = imagePostingan;
        this.like = like;
        this.comments = comments;
        this.share = share;
        this.name = name;
        this.caption = caption;
    }
    public Postingan(int imagePorfil, Uri imagePostingan, int like, int comments, int share, String name, String caption) {
        this.imagePorfil = imagePorfil;
        this.uri = imagePostingan;
        this.like = like;
        this.comments = comments;
        this.share = share;
        this.name = name;
        this.caption = caption;
    }

    public int getImagePorfil() {
        return imagePorfil;
    }

    public int getImagePostingan() {
        return imagePostingan;
    }

    public Uri getUri() {
        return uri;
    }

    public int getLike() {
        return like;
    }

    public int getComments() {
        return comments;
    }

    public int getShare() {
        return share;
    }

    public String getName() {
        return name;
    }

    public String getCaption() {
        return caption;
    }





    protected Postingan(Parcel in) {
        imagePorfil = in.readInt();
        imagePostingan = in.readInt();
        like = in.readInt();
        comments = in.readInt();
        share = in.readInt();
        name = in.readString();
        caption = in.readString();
        uri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Postingan> CREATOR = new Creator<Postingan>() {
        @Override
        public Postingan createFromParcel(Parcel in) {
            return new Postingan(in);
        }

        @Override
        public Postingan[] newArray(int size) {
            return new Postingan[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(imagePorfil);
        dest.writeInt(imagePostingan);
        dest.writeInt(like);
        dest.writeInt(comments);
        dest.writeInt(share);
        dest.writeString(name);
        dest.writeString(caption);
        dest.writeParcelable(uri, flags);

    }
}
