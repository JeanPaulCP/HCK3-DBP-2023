package com.example.hck3dbp.courseassessmentdetails;
import com.example.hck3dbp.courseassessment.CourseAssessment;
import com.example.hck3dbp.professor.Professor;
import com.example.hck3dbp.student.Student;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
@Table(name = "courseAssessmentDetails")
public class CourseAssessmentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseAssessmentDetails_id", nullable = false)
    private Long id;

    private String score;
    private String section;
    private String sectionGroup;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "CourseAssessmentDetails_Student",
            joinColumns = @JoinColumn(name = "courseAssessmentDetails_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Student student;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "CourseAssessmentDetails_Professor",
            joinColumns = @JoinColumn(name = "courseAssessmentDetails_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private Professor professor;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "CourseAssessmentDetails_CourseAssessment",
            joinColumns = @JoinColumn(name = "courseAssessmentDetails_id"),
            inverseJoinColumns = @JoinColumn(name = "courseAssessment_id"))
    private CourseAssessment courseAssessment;

    public CourseAssessmentDetails(){}
    public CourseAssessmentDetails(Long id, String score, String section, String sectionGroup, Student student, Professor professor, CourseAssessment courseAssessment) {
        this.id = id;
        this.score = score;
        this.section = section;
        this.sectionGroup = sectionGroup;
        this.student = student;
        this.professor = professor;
        this.courseAssessment = courseAssessment;
    }

    public Long getId() { return id; }
    public String getScore() { return score; }
    public String getSection() { return section; }
    public String getSectionGroup() { return sectionGroup; }
    public Student getStudent() { return student; }
    public Professor getProfessor() { return professor; }
    public CourseAssessment getCourseAssessment() { return courseAssessment; }

    public void setId(Long id) {this.id = id;}
    public void setScore(String score) { this.score = score; }
    public void setSection(String section) { this.section = section; }
    public void setSectionGroup(String sectionGroup) { this.sectionGroup = sectionGroup; }
    public void setStudent(Student student) { this.student = student; }
    public void setProfessor(Professor professor) { this.professor = professor; }
    public void setCourseAssessment(CourseAssessment courseAssessment) { this.courseAssessment = courseAssessment; }
}