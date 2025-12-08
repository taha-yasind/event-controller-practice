package org.example.eventcontrollerpractice.model;

import java.time.LocalDate;

public class Event {
    private Long id;
    private String name;
    private String location;
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Event(Long id, String name, String location, LocalDate date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;

    }
}
