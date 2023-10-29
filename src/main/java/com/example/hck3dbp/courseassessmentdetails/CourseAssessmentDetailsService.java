package com.example.hck3dbp.courseassessmentdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseAssessmentDetailsService{

    @Autowired
    private CourseAssessmentDetailsRepository courseAssessmentDetailsRepository;

    public List<CourseAssessmentDetails> get_All() {
        return courseAssessmentDetailsRepository.findAll();
    }

    public void saveCourseAssessmentDetails(CourseAssessmentDetails courseAssessmentDetails){
        courseAssessmentDetailsRepository.save(courseAssessmentDetails);
    }

    public Optional<CourseAssessmentDetails> update(Long id, CourseAssessmentDetails courseAssessmentDetails){

        Optional<CourseAssessmentDetails> optionalCourseAssessmentDetails = courseAssessmentDetailsRepository.findById(id);

        if(optionalCourseAssessmentDetails.isPresent()){

            CourseAssessmentDetails existing = optionalCourseAssessmentDetails.get();

            existing.setScore(courseAssessmentDetails.getScore()); // existing sirve para guardar los datos que ya existen en la bdd
            existing.setSection(courseAssessmentDetails.getSection());
            existing.setSectionGroup(courseAssessmentDetails.getSectionGroup());
            existing.setStudent(courseAssessmentDetails.getStudent());
            existing.setProfessor(courseAssessmentDetails.getProfessor());
            existing.setCourseAssessment(courseAssessmentDetails.getCourseAssessment());

            courseAssessmentDetailsRepository.save(existing);
        }

        return optionalCourseAssessmentDetails;
    }

    public Optional<CourseAssessmentDetails> patch(Long id, CourseAssessmentDetails courseAssessmentDetails){

        Optional<CourseAssessmentDetails> optionalCourseAssessmentDetails = courseAssessmentDetailsRepository.findById(id);

        if(optionalCourseAssessmentDetails.isPresent()){

            CourseAssessmentDetails existing = optionalCourseAssessmentDetails.get();

            if (courseAssessmentDetails.getScore() != null) {
                existing.setScore(courseAssessmentDetails.getScore());
            }
            if (courseAssessmentDetails.getSection() != null) {
                existing.setSection(courseAssessmentDetails.getSection());
            }
            if (courseAssessmentDetails.getSectionGroup() != null) {
                existing.setSectionGroup(courseAssessmentDetails.getSectionGroup());
            }
            if (courseAssessmentDetails.getStudent() != null) {
                existing.setStudent(courseAssessmentDetails.getStudent());
            }
            if (courseAssessmentDetails.getProfessor() != null) {
                existing.setProfessor(courseAssessmentDetails.getProfessor());
            }
            if (courseAssessmentDetails.getCourseAssessment() != null){
                existing.setCourseAssessment(courseAssessmentDetails.getCourseAssessment());
            }

            courseAssessmentDetailsRepository.save(existing);
        }

        return optionalCourseAssessmentDetails;
    }

    public Optional<CourseAssessmentDetails> delete(Long id) {

        Optional<CourseAssessmentDetails> optionalCourseAssessmentDetails = courseAssessmentDetailsRepository.findById(id);

        if(optionalCourseAssessmentDetails.isPresent()){
            CourseAssessmentDetails existing = optionalCourseAssessmentDetails.get();
            courseAssessmentDetailsRepository.delete(existing);
        }

        return optionalCourseAssessmentDetails;
    }

    public Optional<CourseAssessmentDetails> get_id(Long id) {
        return courseAssessmentDetailsRepository.findById(id);
    }

    //Se usa Optional mas que todo cuando no estoy seguro que estará presente los datos en la
    //bdd, para el manejo de datos ausentes o presentes de manera incierta.
}
