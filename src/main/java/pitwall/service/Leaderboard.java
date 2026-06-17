package pitwall.service;

import pitwall.client.OpenF1Client;
import pitwall.model.Driver;
import pitwall.model.Team;

import java.util.List;

public class Leaderboard {
    List<Driver> drivers;
    List<Team> teams;

    OpenF1Client openF1Client;

    Leaderboard(OpenF1Client openF1Client, String sessionId) {
        this.openF1Client = openF1Client;

        this.drivers = openF1Client.loadDrivers(sessionId);
        this.teams = openF1Client.loadTeams(sessionId);
    }
}
