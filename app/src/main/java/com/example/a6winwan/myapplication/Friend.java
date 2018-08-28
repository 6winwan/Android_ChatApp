package com.example.a6winwan.myapplication;

/**
 * Created by 6winw on 2017-04-12.
 */

public class Friend {

    public String email;
    public String photo;

    public Friend() {
        // Default constructor required for calls to DataSnapshot.getValue(Comment.class)
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
