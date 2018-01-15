/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author hesham
 */
public class Event implements Serializable {

    private int eventId;
    private String nameEn;
    private String nameAr;
    private String placeEn;
    private String placeAr;
    private Date eventDate;
    private int capacity;
    private EventType type;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getPlaceEn() {
        return placeEn;
    }

    public void setPlaceEn(String placeEn) {
        this.placeEn = placeEn;
    }

    public String getPlaceAr() {
        return placeAr;
    }

    public void setPlaceAr(String placeAr) {
        this.placeAr = placeAr;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.eventId;
        hash = 97 * hash + Objects.hashCode(this.nameEn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (this.eventId != other.eventId) {
            return false;
        }
        if (!Objects.equals(this.nameEn, other.nameEn)) {
            return false;
        }
        if (!Objects.equals(this.placeEn, other.placeEn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Event{" + "eventId=" + eventId + ", nameEn=" + nameEn + ", placeEn=" + placeEn + ", type=" + type + '}';
    }

}
