package com.example.system.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.system.entities.Eventos;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EventosDTO {
    private Long id;
    private String name;
    private String description;
    private String place;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startdate;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime starTime;
    private String email;
    
    public EventosDTO() {
    
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EventosDTO(Long id, String name, String description, String place, LocalDate startdate, LocalDate enDate, LocalTime starTime, LocalTime endtime, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.startdate = startdate;
        this.starTime = starTime;
        this.email = email;
	}

    public EventosDTO(Eventos evt) {
        this.id = evt.getId();
        this.name = evt.getName();
        this.description = evt.getDescription();
        this.place = evt.getPlace();
        this.startdate = evt.getStartdate();
        this.starTime = evt.getStarTime();
        this.email = evt.getEmail();
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

    public LocalTime getStarTime() {
        return starTime;
    }

    public void setStarTime(LocalTime starTime) {
        this.starTime = starTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
