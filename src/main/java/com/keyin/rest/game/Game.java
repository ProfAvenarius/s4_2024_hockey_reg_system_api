package com.keyin.rest.game;

import com.keyin.rest.team.Team;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_sequence")
    @SequenceGenerator(name = "game_sequence", sequenceName = "game_sequence", allocationSize = 1, initialValue = 1)
    private long id;

    @ManyToOne
    private Team homeTeam;

    @ManyToOne
    private Team awayTeam;

    private String location;

    private LocalDateTime scheduledDate;

    // Getters and setters
    public long getId() {return id; }

    public void setId(long id) {this.id = id; }

    public Team getHomeTeam() {return homeTeam; }

    public void setHomeTeam(Team homeTeam) {this.homeTeam = homeTeam; }

    public Team getAwayTeam() {return awayTeam; }

    public void setAwayTeam(Team awayTeam) {this.awayTeam = awayTeam; }

    public String getLocation() {return location; }

    public void setLocation(String location) {this.location = location; }

    public LocalDateTime getScheduledDate() {return scheduledDate; }

    public void setScheduledDate(LocalDateTime scheduledDate) {this.scheduledDate = scheduledDate; }
}





