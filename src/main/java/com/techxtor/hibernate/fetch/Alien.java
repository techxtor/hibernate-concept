package com.techxtor.hibernate.fetch;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
    @Id
    private int aId;
    private String aName;
    private String aColor;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaColor() {
        return aColor;
    }

    public void setaColor(String aColor) {
        this.aColor = aColor;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", aColor='" + aColor + '\'' +
                '}';
    }
}
