package com.security.spring_security.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "name should not be empty")
    @Size(
            min = 2,
            max = 100,
            message = "name should has length not less than 2 & not more than 100 symbols"
    )
    @Column(name = "username")
    private String username;

    @Min(
            value = 1900,
            message = "year of birth should be more than 1900"
    )
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public Person(String username, int yearOfBirth, String password) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
        this.password = password;
    }
}
