package com.keyin.rest.dto;

import com.keyin.rest.team.Team;
import com.keyin.rest.player.Player;

import java.util.List;
import java.util.stream.Collectors;

public class TeamDTO {
    private String name;
    private String divisionName;
    private List<String> playerNames;

    public TeamDTO(Team team) {
        this.name = team.getName();
        this.divisionName = team.getDivision() != null ? team.getDivision().getName() : null;
        this.playerNames = team.getPlayers() != null
                ? team.getPlayers().stream()
                .map(player -> player.getFirstName() + " " + player.getLastName())
                .collect(Collectors.toList())
                : null;
    }

    public String getName() {
        return name;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
