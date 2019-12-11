package com.co.amir.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Person {
    @SerializedName("name")
    private String name;
    @SerializedName("age")
    private String age;

    public Person setPerson(String a,String b){
        name=a;age=b;
        return this;
    }
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
