package com.keyin.rest;

import com.keyin.rest.division.Division;
import com.keyin.rest.division.DivisionRepository;
import com.keyin.rest.player.Player;
import com.keyin.rest.player.PlayerRepository;
import com.keyin.rest.team.Team;
import com.keyin.rest.team.TeamRepository;
import com.keyin.rest.game.Game;
import com.keyin.rest.game.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final DivisionRepository divisionRepo;
    private final PlayerRepository playerRepo;
    private final TeamRepository teamRepo;
    private final GameRepository gameRepo;

    public DataLoader(DivisionRepository divisionRepo, PlayerRepository playerRepo, TeamRepository teamRepo, GameRepository gameRepo) {
        this.divisionRepo = divisionRepo;
        this.playerRepo = playerRepo;
        this.teamRepo = teamRepo;
        this.gameRepo = gameRepo;
    }

    @Override
    public void run(String... args) {
        // Load Divisions
        Division bantam = new Division();
        bantam.setName("Bantam");
        bantam.setStartBirthYear("2009");
        bantam.setEndBirthYear("2010");
        divisionRepo.save(bantam);

        Division midget = new Division();
        midget.setName("PeeWee");
        midget.setStartBirthYear("2007");
        midget.setEndBirthYear("2008");
        divisionRepo.save(midget);

        // Load Players
        Player mark = new Player();
        mark.setFirstName("Mark");
        mark.setLastName("McGwire");
        Calendar dob1 = Calendar.getInstance();
        dob1.set(2009, Calendar.JANUARY, 15);
        mark.setBirthday(dob1);
        playerRepo.save(mark);

        Player babe = new Player();
        babe.setFirstName("Babe");
        babe.setLastName("Ruth");
        Calendar dob2 = Calendar.getInstance();
        dob2.set(2008, Calendar.JUNE, 22);
        babe.setBirthday(dob2);
        playerRepo.save(babe);

        // Load Teams
        Team wolves = new Team();
        wolves.setName("Wolves");
        wolves.setDivision(bantam);
        wolves.setPlayers(List.of(mark));
        teamRepo.save(wolves);

        Team bears = new Team();
        bears.setName("Bears");
        bears.setDivision(midget);
        bears.setPlayers(List.of(babe));
        teamRepo.save(bears);

        // Load Game
        Game game = new Game();
        game.setHomeTeam(wolves);
        game.setAwayTeam(bears);
        game.setLocation("Downtown Arena");
        game.setScheduledDate(LocalDateTime.of(2025, 6, 15, 19, 0));
        gameRepo.save(game);

        System.out.println("Test data loaded successfully.");
    }
}
