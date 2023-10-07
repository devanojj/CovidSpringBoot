package com.example.springboot6.springboot6.Models;

import javax.persistence.*;

@Entity
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String weekNumber;

    public Week() {

    }

    public Week(String weekNumber) {
        this.weekNumber = weekNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(String weekNumber) {
        this.weekNumber = weekNumber;
    }


}
