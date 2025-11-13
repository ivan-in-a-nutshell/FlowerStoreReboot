package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Getter
    @Setter
    private Long id;

    @Column(
            nullable = false,
            unique = true
    )
    @Getter
    @Setter
    private String email;

    @Column(nullable = false)
    @Getter
    @Setter
    private LocalDate dob;

    @Transient
    @Setter
    private Integer age;

    public AppUser(String email, LocalDate dob) {
        this.email = email;
        this.dob = dob;
    }

    public Integer getAge() {
        if (this.dob == null) {
            return null;
        }
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
