package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quiz")
@Getter
@Setter
public class quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizID")
    private Long quizID;

    @Column(name = "quizNot")//@Column(name = "quizNot", precision = 5, scale = 2)
    private Double quizNot;

}
