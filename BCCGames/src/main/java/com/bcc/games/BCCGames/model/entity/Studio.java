package com.bcc.games.BCCGames.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity(name = "studios")
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;

    public Studio(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
