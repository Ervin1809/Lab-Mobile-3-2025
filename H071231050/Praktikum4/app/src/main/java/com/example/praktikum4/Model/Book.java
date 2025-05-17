package com.example.praktikum4.Model;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class Book {
    String title, author, blurb, tahunTerbit, image;
    ArrayList<String> genres;
    Uri imageUri;

    public Book(String title, String author, String blurb, String tahunTerbit, String image,  boolean statusLike,ArrayList<String> genres) {
        this.title = title;
        this.author = author;
        this.blurb = blurb;
        this.tahunTerbit = tahunTerbit;
        this.image = image;
        this.genres = genres;
        this.statusLike = statusLike;
    }
    public Book(String title, String author, String blurb, String tahunTerbit, Uri image,  boolean statusLike,ArrayList<String> genres) {
        this.title = title;
        this.author = author;
        this.blurb = blurb;
        this.tahunTerbit = tahunTerbit;
        this.imageUri = image;
        this.genres = genres;
        this.statusLike = statusLike;
    }

    boolean statusLike;
    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public boolean isStatusLike() {
        return statusLike;
    }

    public void setStatusLike(boolean statusLike) {
        this.statusLike = statusLike;
    }

}

