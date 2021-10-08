package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("f3Nikgflid5CiZ18JodtBNIjE7rN2lyFKRHqlCSo")
                .clientKey("yMuR2QVfKUh9oRmYHaNhwCesmZtUwMa0aKp8jlWl")
                .server("https://parseapi.back4app.com/")
                .build());
        }
    }