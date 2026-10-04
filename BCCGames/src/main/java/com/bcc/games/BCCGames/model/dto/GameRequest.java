package com.bcc.games.BCCGames.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GameRequest {
    private String title;
    private String genre;
    private Double price;
    private Long studioId;

    public GameRequest(String title, String genre, Double price, Long studioId) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.studioId = studioId;
    }
}
