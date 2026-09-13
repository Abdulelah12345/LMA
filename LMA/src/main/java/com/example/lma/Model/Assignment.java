package com.example.lma.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {

    @NotBlank(message = "Id cannot be empty")
    private String id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotNull(message = "Deadline cannot be empty")
    private LocalDate deadline;

    @Positive(message = "Max grade must be positive")
    private int maxGrade;

    @Pattern(regexp = "pending|submitted|graded",message = "Status must be pending, submitted, or graded")
    private String status;
}