package com.techxtor.hibernate.embeddable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alien_table")
public class Alien {
    @Id
    private int aId;

    @Embedded
    private AlienName aName;

    private String aColor;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public AlienName getaName() {
        return aName;
    }

    public void setaName(AlienName aName) {
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
                ", aName=" + aName +
                ", aColor='" + aColor + '\'' +
                '}';
    }
}
