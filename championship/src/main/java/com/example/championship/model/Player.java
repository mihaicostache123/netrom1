package com.example.championship.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PLAYER_NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "JERSEY_NUMBER")
    private int number;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate signingDate;


    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

}
