package com.example.springboot6.springboot6.Models;

import javax.persistence.*;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;


    private String country;

    private String date;

    private String value;

    private String yearWeek;

    private String countryCodes;



    public Country() {

    }

    public Country(String country, String date, String value, String yearWeek, String countryCodes) {
        this.country = country;
        this.date = date;
        this.value = value;
        this.yearWeek = yearWeek;
        this.countryCodes = countryCodes;

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getYearWeek() {
        return yearWeek;
    }

    public void setYearWeek(String yearWeek) {
        this.yearWeek = yearWeek;
    }

    public String getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(String countryCodes) {
        this.countryCodes = countryCodes;
    }


}
