package pitwall.controller;

import org.springframework.stereotype.Component;

import pitwall.client.OpenF1Client;
import pitwall.service.Leaderboard;

@Component
public class Controller {
    OpenF1Client openF1Client;
    Leaderboard leaderboard;

    Controller(OpenF1Client openF1Client) {
        String sessionId = "9158";

        leaderboard = new Leaderboard(openF1Client, sessionId);
    }
}
