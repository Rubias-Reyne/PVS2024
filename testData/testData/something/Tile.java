package gui.maze;

public class Tile {
    Tile[] possibleDirections;
    boolean orb, target;

    public Tile(Tile[] possibleDirections, boolean orb, boolean target) {
        this.possibleDirections = possibleDirections;
        this.orb = orb;
        this.target = target;
    }

}
