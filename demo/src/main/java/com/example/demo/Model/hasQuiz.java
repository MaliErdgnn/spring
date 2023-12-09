package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hasQuiz")
@Getter
@Setter
public class hasQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizID")
    private Long quizID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hesapID")
    private Long hesapID;

}
