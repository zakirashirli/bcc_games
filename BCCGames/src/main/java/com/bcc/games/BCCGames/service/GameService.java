package com.bcc.games.BCCGames.service;

import com.bcc.games.BCCGames.model.dto.GameRequest;
import com.bcc.games.BCCGames.model.dto.GameResponse;
import com.bcc.games.BCCGames.model.entity.Game;
import com.bcc.games.BCCGames.model.entity.Studio;
import com.bcc.games.BCCGames.repository.GameRepository;
import com.bcc.games.BCCGames.repository.StudioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GameService {

    private final GameRepository gameRepository;
    private final StudioRepository studioRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    // DTO -> Entity
    public GameResponse createGame(GameRequest gameRequest) {

        Long studioId = gameRequest.getStudioId();

        Studio studio = studioRepository.findById(studioId)
                .orElseThrow(() -> new RuntimeException("Not found game"));

        Game game = new Game();

        game.setTitle(gameRequest.getTitle());
        game.setGenre(gameRequest.getGenre());
        game.setPrice(gameRequest.getPrice());
        game.setStudio(studio);

        // convertToResponse Entity -> DTO(Data Transfer Object)
        Game savedGame = gameRepository.save(game);
        return convertToResponse(savedGame);
    }

    public void deleteById(Long id) {
        gameRepository.deleteById(id);
    }


    // Query Methods
    public List<Game> getByTitle(String title) {
        return gameRepository.findByTitleContainingIgnoreCase(title);
    }


    // convertToResponse Entity -> DTO(Data Transfer Object)
    private GameResponse convertToResponse(Game game) {

        return new GameResponse(
                game.getId(),
                game.getTitle(),
                game.getGenre(),
                game.getPrice(),
                game.getStudio().getName()
        );
    }
}
