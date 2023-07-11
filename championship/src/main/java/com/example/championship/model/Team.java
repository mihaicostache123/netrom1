package com.example.championship.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TEAM_NAME")
    private String name;

    @Column(name = "COUNTRY")
    private String country;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "team1")
    private List<Game> gamesHome = new ArrayList<>();

    @OneToMany(mappedBy = "team2")
    private List<Game> gamesAway = new ArrayList<>();
}
