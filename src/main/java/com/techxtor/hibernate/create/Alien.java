package com.techxtor.hibernate.create;

import javax.persistence.*;


@Entity // default settings
// @Entity( name = "alien_table") // creates entity with name "alien_table" and same name table is created
// @Table(name = "alien_table") // creates table name with name "alien_table" but does not change entity name
public class Alien {
    @Id
    private int aId;
//    @Column(name = "alien_Name") // change column name
    private String aName;
//    @Transient // does not store
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
