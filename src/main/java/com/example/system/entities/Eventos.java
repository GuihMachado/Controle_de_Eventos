package com.example.system.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.system.dtos.EventosInsertDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Eventos")
public class Eventos implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private String place;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startdate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate enDate;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime starTime;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalTime endtime;
    private String email;

    public Eventos() {
     
	}

    public Eventos(EventosInsertDTO dto) {
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.place = dto.getPlace();
        this.startdate = dto.getStartdate();
        this.enDate = dto.getEnDate();
        this.starTime = dto.getStarTime();
        this.endtime = dto.getEndtime();
        this.email = dto.getEmail();
    }
    
    public LocalTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    public LocalTime getStarTime() {
        return starTime;
    }

    public void setStarTime(LocalTime starTime) {
        this.starTime = starTime;
    }

    public LocalDate getEnDate() {
        return enDate;
    }

    public void setEnDate(LocalDate enDate) {
        this.enDate = enDate;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Eventos other = (Eventos) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
