package com.example.hck3dbp.courseassessment;
import com.example.hck3dbp.course.Course;
import com.example.hck3dbp.periodo.Periodo;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // Esta línea es
// para evitar el error de recursión infinita al momento de hacer el GET
// La recursión infinita es porque se está haciendo un GET de un curso y en el curso hay un atributo que es
// de tipo CourseAssessment, entonces al hacer el GET de un curso, se hace el GET de CourseAssessment y en
// CourseAssessment hay un atributo que es de tipo Course, entonces al hacer el GET de CourseAssessment, se
// hace el GET de Course y en Course hay un atributo que es de tipo CourseAssessment, entonces al hacer el
// GET de Course, se hace el GET de CourseAssessment y en CourseAssessment hay un atributo que es de tipo
// Course, entonces al hacer el GET de CourseAssessment, se hace el GET de Course y así sucesivamente.
@Table(name = "courseAssessment")
public class CourseAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseAssessment_id", nullable = false)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // FetchType.LAZY es para que no se cargue
    // toda la información de una vez en la BD y CascadeType.ALL es para que se actualice la información en
    // todas las tablas que tengan relación con esta tabla
    @JoinTable(name = "courseAssessment_Course",
            joinColumns = @JoinColumn(name = "courseAssessment_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Course course;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "courseAssessment_Periodo",
            joinColumns = @JoinColumn(name = "courseAssessment_id"),
            inverseJoinColumns = @JoinColumn(name = "periodo_id"))
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
