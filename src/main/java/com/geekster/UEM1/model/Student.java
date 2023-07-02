package com.geekster.UEM1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    @NotNull
    @Size(min = 2, max = 50)
    @Pattern(regexp = "[A-Z][a-z]*")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Pattern(regexp = "[A-Z][a-z]*")
    private String lastName;

    @NotNull
    @Min(18)
    @Max(25)
    private Integer age;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Department department;

}