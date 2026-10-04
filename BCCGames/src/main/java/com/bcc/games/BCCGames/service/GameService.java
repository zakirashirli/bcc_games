package com.bcc.games.BCCGames.service;

import com.bcc.games.BCCGames.entity.Game;
import com.bcc.games.BCCGames.entity.Studio;
import com.bcc.games.BCCGames.repository.GameRepository;
import com.bcc.games.BCCGames.repository.StudioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final StudioRepository studioRepository;

    public GameService(GameRepository gameRepository, StudioRepository studioRepository) {
        this.gameRepository = gameRepository;
        this.studioRepository = studioRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game createGame(Game game) {

        Long studioId = game.getStudio().getId();

        Studio studio = studioRepository.findById(studioId)
                .orElseThrow(() -> new RuntimeException("Not found game"));

        game.setStudio(studio);
        game.setTitle(game.getTitle());
        game.setGenre(game.getGenre());
        game.setPrice(game.getPrice());

        return gameRepository.save(game);
    }

    public void deleteById(Long id) {
        gameRepository.deleteById(id);
    }


    // Query Methods
    public List<Game> getByTitle(String title) {
        return gameRepository.findByTitleContainingIgnoreCase(title);
    }

}
