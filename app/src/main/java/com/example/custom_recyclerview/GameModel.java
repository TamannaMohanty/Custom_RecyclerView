package com.example.custom_recyclerview;

public class GameModel {

    String name,country,people;

    public GameModel(String name, String country, String people) {
        this.name = name;
        this.country = country;
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }
}
