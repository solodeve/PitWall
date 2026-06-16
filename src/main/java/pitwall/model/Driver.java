package pitwall.model;

public record Driver(
    String name,
    String lastName,
    float championshipPoint,
    Team team
) {}
