package com.keyin.rest.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/game")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/game/{id}")
    public Game getGameById(@PathVariable long id) {
        return gameService.getGameById(id);
    }

    @GetMapping("/game_search")
    public List<Game> searchGamesByLocation(@RequestParam String location) {
        return gameService.getGamesByLocation(location);
    }

    @PostMapping("/game")
    public Game createGame(@RequestBody Game game) {
        return gameService.createGame(game);
    }
    @PutMapping("/game/{id}")
    public Game updateGame(@PathVariable long id, @RequestBody Game game) {
        return gameService.updateGame(id, game);
    }

    @DeleteMapping("/game/{id}")
    public void deleteGame(@PathVariable long id) {
        gameService.deleteGame(id);
    }
}

