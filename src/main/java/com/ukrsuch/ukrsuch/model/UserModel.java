package com.ukrsuch.ukrsuch.model;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users")
public class UserModel {
	@Id
    @Column(name = "id")
    private int id;

	@NaturalId
    @Column(name = "nik")
    private String nik;

    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }


	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
   	public String toString() {
   		return "UserModel [id=" + id + ", nik=" + nik + ", password=" + password + ", email=" + email + "]";
   	}
}
