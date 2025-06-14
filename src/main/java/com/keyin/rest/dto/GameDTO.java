package com.keyin.rest.dto;

import com.keyin.rest.game.Game;

import java.time.LocalDateTime;

public class GameDTO {
    private String location;
    private LocalDateTime scheduledAt;
    private String homeTeamName;
    private String awayTeamName;

    public GameDTO(Game game) {
        this.location = game.getLocation();
        this.scheduledAt = game.getScheduledDate();
        this.homeTeamName = game.getHomeTeam() != null ? game.getHomeTeam().getName() : null;
        this.awayTeamName = game.getAwayTeam() != null ? game.getAwayTeam().getName() : null;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }
}
