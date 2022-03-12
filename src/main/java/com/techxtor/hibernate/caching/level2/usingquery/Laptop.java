package com.techxtor.hibernate.caching.level2.usingquery;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
    @Id
    private int lId;
    private String lName;

    @ManyToOne
    @JoinColumn
    private Student student;

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lId=" + lId +
                ", lName='" + lName + '\'' +
                '}';
    }
}
