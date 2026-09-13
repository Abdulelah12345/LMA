package com.example.lma.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class Course {

    @NotBlank(message = "Id cannot be empty")
    private String id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotBlank(message = "Category cannot be empty")
    private String category;

    @Positive(message = "Duration must be positive")
    private int duration;
}
