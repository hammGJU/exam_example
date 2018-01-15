/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.models;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author hesham
 */
public class EventType implements Serializable {

    private int typeId;
    private String nameEn;
    private String nameAr;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.typeId;
        hash = 11 * hash + Objects.hashCode(this.nameEn);
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
        final EventType other = (EventType) obj;
        if (this.typeId != other.typeId) {
            return false;
        }
        if (!Objects.equals(this.nameEn, other.nameEn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EventType{" + "typeId=" + typeId + ", nameEn=" + nameEn + '}';
    }

}
