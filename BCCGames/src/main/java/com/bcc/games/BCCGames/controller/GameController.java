package com.bcc.games.BCCGames.controller;

import com.bcc.games.BCCGames.entity.Game;
import com.bcc.games.BCCGames.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<Game> getAll() {
        return gameService.getAllGames();
    }

    @PostMapping("/games")
    public Game getAll(@RequestBody Game game) {
        return gameService.createGame(game);
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
