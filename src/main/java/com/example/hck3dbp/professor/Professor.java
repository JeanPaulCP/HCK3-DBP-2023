package com.example.hck3dbp.professor;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id", nullable = false)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String fullname;

    public Professor(){}
    public Professor(Long id, String name, String lastName, String email, String fullname) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.fullname = fullname;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getFullname() { return fullname; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setFullname(String fullname) { this.fullname = fullname; }
}
