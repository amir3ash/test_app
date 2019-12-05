package com.co.amir.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Person {
    @SerializedName("name")
    String name;
    @SerializedName("age")
    String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
