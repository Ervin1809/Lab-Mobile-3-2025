package com.example.instagram;

public class UserStats {
    public String name;
    public int followers;
    public int following;
    public int posts;
    public int profile;

    public UserStats(String name, int profile, int followers, int following, int posts) {
        this.name = name;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
        this.profile = profile;
    }

    // Getter custom dengan formatting
    public String getFormattedFollowers() {
        return formatNumber(followers);
    }

    public String getFormattedFollowing() {
        return formatNumber(following);
    }

    private String formatNumber(int number) {
        if (number >= 1000000) {
            return (number / 1000000) + "jt";
        } else if (number >= 10000) {
            return (number / 10000) + "rb";
        } else {
            return String.valueOf(number);
        }
    }
}



