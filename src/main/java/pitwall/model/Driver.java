package pitwall.model;

public record Driver(
    String name,
    int number,
    float championshipPoint,
    Team team
) {}
