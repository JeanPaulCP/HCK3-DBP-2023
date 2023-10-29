package com.example.hck3dbp.courseassessmentdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course_assessment_details")
public class CourseAssessmentDetailsController {
    @Autowired
    private CourseAssessmentDetailsService courseAssessmentDetailsService;

    @GetMapping
    public ResponseEntity< List<CourseAssessmentDetails> > todo(){
        List<CourseAssessmentDetails> todope = courseAssessmentDetailsService.get_All();
        return new ResponseEntity<>(todope,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> guardar(@RequestBody CourseAssessmentDetails courseAssessmentDetails) {

        courseAssessmentDetailsService.saveCourseAssessmentDetails(courseAssessmentDetails);

        return ResponseEntity.status(201).body("Created!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> cambiarTodo(@PathVariable Long id, @RequestBody CourseAssessmentDetails courseAssessmentDetails) {

        Optional<CourseAssessmentDetails> existe_o_no = courseAssessmentDetailsService.update(id, courseAssessmentDetails);

        return existe_o_no.isPresent() ? ResponseEntity.status(200).body("Updated!") :
                ResponseEntity.status(404).body("Not Found");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> cambios(@PathVariable Long id, @RequestBody CourseAssessmentDetails courseAssessmentDetails){

        Optional<CourseAssessmentDetails> existe_o_no = courseAssessmentDetailsService.patch(id,courseAssessmentDetails);

        return existe_o_no.isPresent() ? ResponseEntity.status(200).body("Updated partially!") :
                ResponseEntity.status(404).body("Not Found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar_uno(@PathVariable Long id){

        Optional<CourseAssessmentDetails> existe_o_no = courseAssessmentDetailsService.delete(id);

        return existe_o_no.isPresent() ? ResponseEntity.status(200).body("Deleted!") :
                ResponseEntity.status(404).body("Not Found");
    }

    @GetMapping("/{id}")
    public ResponseEntity< CourseAssessmentDetails > mostrar_uno(@PathVariable Long id){
        Optional<CourseAssessmentDetails> existe_o_no = courseAssessmentDetailsService.get_id(id);

        if (existe_o_no.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(existe_o_no.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // build es para cuando no hay body
        }

    }
}
