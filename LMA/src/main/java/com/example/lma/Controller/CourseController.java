package com.example.lma.Controller;


import com.example.lma.API.ApiResponse;
import com.example.lma.Model.Course;
import com.example.lma.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity<?> getCourses() {

        ArrayList<Course> courses = courseService.getCourse();

        if (courses.isEmpty()) {
            return ResponseEntity.status(400)
                    .body(new ApiResponse("There are no courses to be shown"));
        }

        return ResponseEntity.status(200).body(courses);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid Course course, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        courseService.addCourse(course);

        return ResponseEntity.status(200).body(new ApiResponse("Course has been added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable String id, @RequestBody @Valid Course course, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean updated = courseService.updateCourse(id, course);

        if (!updated) {
            return ResponseEntity.status(400).body(new ApiResponse("There is no course under this id"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Course has been updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id) {

        boolean deleted = courseService.deleteCourse(id);

        if (!deleted) {
            return ResponseEntity.status(400).body(new ApiResponse("There is no course under this id"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Course has been deleted"));
    }


    @GetMapping("/getid/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable String id) {

        Course course = courseService.getId(id);

        if (course == null) {
            return ResponseEntity.status(400).body(new ApiResponse("There is no course under this ID"));
        }

        return ResponseEntity.status(200).body(course);
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<?> getByCategory(@PathVariable String category) {

        ArrayList<Course> result = courseService.getByCategory(category);

        if (result.isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("There are no courses under this category"));
        }

        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/duration/{duration}")
    public ResponseEntity<?> getByDuration(@PathVariable int duration) {

        ArrayList<Course> result = courseService.getByDuration(duration);

        if (result.isEmpty()) {
            return ResponseEntity.status(400)
                    .body(new ApiResponse("There are no courses with this duration"));
        }

        return ResponseEntity.status(200).body(result);
    }


    @GetMapping("/description/{word}")
    public ResponseEntity<?> getByDescription(@PathVariable String word) {

        ArrayList<Course> result = courseService.getByDescription(word);

        if (result.isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("There are no courses with this description"));
        }

        return ResponseEntity.status(200).body(result);
    }


}
