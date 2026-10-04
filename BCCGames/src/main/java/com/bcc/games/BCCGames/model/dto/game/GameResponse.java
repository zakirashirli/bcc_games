package com.bcc.games.BCCGames.model.dto.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GameResponse {
    private Long id;
    private String title;
    private String genre;
    private Double price;
    private String studioName;

    public GameResponse(Long id, String title, String genre, Double price, String studioName) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.studioName = studioName;
    }
}
