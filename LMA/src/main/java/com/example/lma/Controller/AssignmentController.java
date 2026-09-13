package com.example.lma.Controller;

import com.example.lma.API.ApiResponse;
import com.example.lma.Model.Assignment;
import com.example.lma.Service.AssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/assignment")
public class AssignmentController {

    private final AssignmentService assignmentService;


    @GetMapping("/get")
    public ResponseEntity<?> getAssignments() {

        ArrayList<Assignment> assignments = assignmentService.getAssignments();

        if (assignments.isEmpty()) {
            return ResponseEntity.status(400)
                    .body(new ApiResponse("There are no assignments to be shown"));
        }

        return ResponseEntity.status(200).body(assignments);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addAssignment(
            @RequestBody @Valid Assignment assignment,
            Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        assignmentService.addAssignment(assignment);

        return ResponseEntity.status(200)
                .body(new ApiResponse("Assignment has been added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAssignment(@PathVariable String id, @RequestBody @Valid Assignment assignment, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean updated = assignmentService.updateAssignment(id, assignment);

        if (!updated) {
            return ResponseEntity.status(400).body(new ApiResponse("There is no assignment under this id"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Assignment has been updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAssignment(@PathVariable String id) {

        boolean deleted = assignmentService.deleteAssignment(id);

        if (!deleted) {
            return ResponseEntity.status(400).body(new ApiResponse("There is no assignment under this id"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Assignment has been deleted"));
    }


    @GetMapping("/getid/{id}")
    public ResponseEntity<?> getAssignmentById(@PathVariable String id) {

        Assignment assignment = assignmentService.getId(id);

        if (assignment == null) {
            return ResponseEntity.status(400).body(new ApiResponse("There is no assignment under this ID"));
        }

        return ResponseEntity.status(200).body(assignment);
    }


    @GetMapping("/status/{status}")
    public ResponseEntity<?> getByStatus(@PathVariable String status) {

        ArrayList<Assignment> result = assignmentService.getByStatus(status);

        if (result.isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("There are no assignments with this status"));
        }

        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getByTitle(@PathVariable String title) {

        Assignment assignment = assignmentService.getByTitle(title);

        if (assignment == null) {
            return ResponseEntity.status(400).body(new ApiResponse("There is no assignment under this title"));
        }

        return ResponseEntity.status(200).body(assignment);
    }


    @GetMapping("/notgraded")
    public ResponseEntity<?> getNotGraded() {

        ArrayList<Assignment> result = assignmentService.getNotGraded();

        if (result.isEmpty()) {
            return ResponseEntity.status(400)
                    .body(new ApiResponse("There are no assignments that are not graded"));
        }

        return ResponseEntity.status(200).body(result);
    }
}