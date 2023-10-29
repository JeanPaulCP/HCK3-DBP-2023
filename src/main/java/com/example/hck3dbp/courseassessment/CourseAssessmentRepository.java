package com.example.hck3dbp.courseassessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseAssessmentRepository extends JpaRepository<CourseAssessment,Long>{

}
