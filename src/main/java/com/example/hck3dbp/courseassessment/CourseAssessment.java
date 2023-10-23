package com.example.hck3dbp.courseassessment;
import com.example.hck3dbp.course.Course;
import com.example.hck3dbp.coursetype.CourseType;
import com.example.hck3dbp.periodo.Periodo;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator =
        ObjectIdGenerators.PropertyGenerator.class, property = "id")

@Table(name = "courseAssessment")
public class CourseAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseAssessment_id", nullable = false)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course; //varias evaluaciones tiene un curso.
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;
    private String title;
    private String tipoNota;
    private String numNota;
    private String nomenclatura;

    public CourseAssessment(){}
    public CourseAssessment(Long id, Course course, Periodo periodo, String title, String tipoNota, String numNota, String nomenclatura) {
        this.id = id;
        this.course = course;
        this.periodo = periodo;
        this.title = title;
        this.tipoNota = tipoNota;
        this.numNota = numNota;
        this.nomenclatura = nomenclatura;
    }

    public Long getId() { return id; }
    public Course getCourse() { return course; }
    public Periodo getPeriodo() { return periodo; }
    public String getTitle() { return title; }
    public String getTipoNota() { return tipoNota; }
    public String getNumNota() { return numNota; }
    public String getNomenclatura() { return nomenclatura; }

    public void setId(Long id) { this.id = id; }
    public void setCourse(Course course) { this.course = course; }
    public void setPeriodo(Periodo periodo) { this.periodo = periodo; }
    public void setTitle(String title) { this.title = title; }
    public void setTipoNota(String tipoNota) { this.tipoNota = tipoNota; }
    public void setNumNota(String numNota) { this.numNota = numNota; }
    public void setNomenclatura(String nomenclatura) { this.nomenclatura = nomenclatura; }
}
