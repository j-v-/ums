package com.jv.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name="users")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String firstname;
    private String lastname;
    private Date dob;
    @Column(name="isactive")
    private boolean isActive;

    public User(){

    }

    public User(String title, String firstname, String lastname, Date dob, boolean isActive){
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
