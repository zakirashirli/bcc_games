package com.bcc.games.BCCGames.controller;

import com.bcc.games.BCCGames.model.dto.GameRequest;
import com.bcc.games.BCCGames.model.dto.GameResponse;
import com.bcc.games.BCCGames.model.entity.Game;
import com.bcc.games.BCCGames.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GameController {

    private final GameService gameService;

    @GetMapping("/games")
    public List<Game> getAll() {
        return gameService.getAllGames();
    }

    @PostMapping("/games")
    public GameResponse getAll(@RequestBody GameRequest gameRequest) {
        return gameService.createGame(gameRequest);
    }

    @DeleteMapping("/games/delete/{id}")
    public void delete(@PathVariable Long id) {
        gameService.deleteById(id);
    }

    // Query Methods
    @GetMapping("/games/{title}")
    public List<Game> getAllByTitle(@RequestParam String title) {
        return gameService.getByTitle(title);
    }
}
