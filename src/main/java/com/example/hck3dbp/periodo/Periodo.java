package com.example.hck3dbp.periodo;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Period;

@Entity
@Table(name = "periodo")
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "periodo_id", nullable = false)
    private Long id;
    private String name;
    private String code;

    public Periodo(){}

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getCode() { return code; }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setCode(String code) { this.code = code; }
}
