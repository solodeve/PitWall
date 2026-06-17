package pitwall.client;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import pitwall.model.Driver;
import pitwall.model.Team;

@Component // tells Spring to automatically detect and manage this class as a bean
public class OpenF1Client {
    WebClient webClient;

    OpenF1Client(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Team> loadTeams(String sessionId) {
        return null;
    }
    
    public List<Driver> loadDrivers(String sessionId) {
        return null;
    }
}
