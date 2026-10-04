package com.bcc.games.BCCGames.controller;

import com.bcc.games.BCCGames.model.entity.Studio;
import com.bcc.games.BCCGames.service.StudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudioController {

    private final StudioService studioService;

    @GetMapping("/studios")
    public List<Studio> getAll() {
        return studioService.getAllStudios();
    }

    @PostMapping("/studios")
    public Studio getAll(@RequestBody Studio studio) {
        return studioService.createStudio(studio);
    }

    @DeleteMapping("/studios/delete/{id}")
    public void delete(@PathVariable Long id) {
        studioService.deleteById(id);
    }
}
