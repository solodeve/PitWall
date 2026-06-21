package pitwall.client;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import pitwall.model.Driver;
import pitwall.model.Team;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Component // tells Spring to automatically detect and manage this class as a bean
public class OpenF1Client {
    WebClient webClient;
    ObjectMapper mapper;

    public OpenF1Client(WebClient webClient) {
        this.webClient = webClient;
        this.mapper = new ObjectMapper();
    }

    public List<Team> loadTeams(String sessionId) {
        List<Team> teams = new ArrayList<>();
        return teams;
    }

    public List<Driver> loadDrivers(String sessionId) {
        List<Driver> drivers = new ArrayList<>();

        // get the driver
        String stringResponse = webClient.get()
            .uri("/drivers?&session_key={sessionid}", sessionId)
            .retrieve()
            .bodyToMono(String.class)
            .block();
        
        JsonNode root = mapper.readTree(stringResponse);           

        for (JsonNode driver : root) {
            String name = driver.get("full_name").toString();
            System.out.println(name);
        }

        // get the championship point for each driver
        stringResponse = webClient.get()
            .uri("/championship_drivers?session_key={sessionid}", sessionId)
            .retrieve()
            .bodyToMono(String.class)
            .block();
        
        root = mapper.readTree(stringResponse);
        for (JsonNode driver : root) {
            // ...
        }

        return drivers;
    }
}
