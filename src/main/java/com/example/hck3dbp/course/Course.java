package com.example.hck3dbp.course;
import com.example.hck3dbp.coursetype.CourseType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.awt.geom.Area;
import java.util.List;

@Entity
@JsonIdentityInfo(generator =
        ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name= "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long id;
    private Integer credits;
    private String name;
    // private CourseContent courseContent; no existe esta clase
    private String code;
    //private Area area; no deja usar Area
    private String HRGroup;
    private Integer cycle;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "coursetype_id")
    private CourseType courseTypes;
    private String VRGroup;

    public Course(){}
    public Course(Long id, Integer credits, String name, String code, String HRGroup, Integer cycle, CourseType courseTypes, String VRGroup) {
        this.id = id;
        this.credits = credits;
        this.name = name;
        this.code = code;
        this.HRGroup = HRGroup;
        this.cycle = cycle;
        this.courseTypes = courseTypes;
        this.VRGroup = VRGroup;
    }

    public Long getId() { return id; }
    public Integer getCredits() { return credits; }
    public String getName() { return name; }
    public String getCode() { return code; }
    public String getHRGroup() { return HRGroup; }
    public Integer getCycle() { return cycle; }
    public CourseType getCourseTypes() { return courseTypes; }
    public String getVRGroup() { return VRGroup; }

    public void setId(Long id) { this.id = id; }
    public void setCredits(Integer credits) { this.credits = credits; }
    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setHRGroup(String HRGroup) { this.HRGroup = HRGroup;}
    public void setCycle(Integer cycle) { this.cycle = cycle; }
    public void setCourseTypes(CourseType courseTypes) { this.courseTypes = courseTypes; }
    public void setVRGroup(String VRGroup) { this.VRGroup = VRGroup; }
}
