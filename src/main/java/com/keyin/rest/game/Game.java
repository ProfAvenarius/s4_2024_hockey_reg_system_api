package com.keyin.rest.game;

import com.keyin.rest.division.Division;
import com.keyin.rest.team.Team;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.util.Calendar;

@Entity
public class Game {

    @Id
    @SequenceGenerator(name = "game_sequence", sequenceName = "game_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "game_sequence")
    private long id;
    private Team homeTeam;
    private Team awayTeam;
    private String location;
    private Calendar gameDay;
    private Division divisionPlay;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getHomeTeam() {return homeTeam; }

    public void setHomeTeam(Team homeTeam) {this.homeTeam = homeTeam; }

    public Team getAwayTeam() {return awayTeam; }

    public void setAwayTeam(Team awayTeam) {this.awayTeam = awayTeam; }

    public String getLocation() {return location; }

    public void setLocation(String location) {this.location = location; }

    public Calendar getGameDay() {return gameDay; }

    public void setAwayGameDay(Calendar gameDay) {this.gameDay = gameDay; }


}






