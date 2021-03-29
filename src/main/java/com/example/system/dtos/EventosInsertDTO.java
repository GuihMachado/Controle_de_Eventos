package com.example.system.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EventosInsertDTO {
    
    private String name;  
    private String description;
    private String place;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startdate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate enDate;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime starTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endtime;
    private String email;

    public EventosInsertDTO() {

    }
    
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public LocalDate getStartdate() {
        return startdate;
    }
    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }
    public LocalDate getEnDate() {
        return enDate;
    }
    public void setEnDate(LocalDate enDate) {
        this.enDate = enDate;
    }
    public LocalTime getStarTime() {
        return starTime;
    }
    public void setStarTime(LocalTime starTime) {
        this.starTime = starTime;
    }
    public LocalTime getEndtime() {
        return endtime;
    }
    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }
}
