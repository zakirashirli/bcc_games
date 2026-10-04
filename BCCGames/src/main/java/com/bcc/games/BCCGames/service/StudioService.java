package com.bcc.games.BCCGames.service;

import com.bcc.games.BCCGames.entity.Studio;
import com.bcc.games.BCCGames.repository.StudioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {

    private final StudioRepository studioRepository;

    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public List<Studio> getAllStudios() {
        return studioRepository.findAll();
    }

    public Studio getStudioById(Long id) {
        return studioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No studio with id: " + id));
    }

    public Studio createStudio(Studio studio) {
        return studioRepository.save(studio);
    }

    public void deleteById(Long id) {
        studioRepository.deleteById(id);
    }
}
