package com.example.hck3dbp.coursetype;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Table(name= "courseType")
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseType_id", nullable = false)
    private Long id;
    private String name;

    public CourseType(){}
    public CourseType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setId(Long id) { this.id = id;}

    public void setName(String name) { this.name = name; }
}
