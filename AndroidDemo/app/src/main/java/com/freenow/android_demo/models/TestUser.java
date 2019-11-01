package com.freenow.android_demo.models;

public class TestUser extends User {

    private String mPassword;

    public TestUser(String username, String salt, String sha256, String password) {
        super(username, salt, sha256);
        mPassword = password;
    }

    public String getPassword() {
        return mPassword;
    }
}
