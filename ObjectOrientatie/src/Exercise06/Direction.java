package Exercise06;

/**
 * @author Sjaak Smetsers
 * @version 1.2
 * @date 28-02-2015
 * An enumeration type for the 4 points of the compass 
 * Each constant has 2 (final) int attributes indicating
 * the displacement of each direction on a 2-dimensional grid 
 * of which the origin is located in the upper left corner
 */
public enum Direction
{
    NORTH (-1, 0), EAST (0, 1), SOUTH(1, 0), WEST(0, -1);
    
    private final int dx, dy;
    private Direction (int dy, int dx) {
        this.dx = dx;
        this.dy = dy;
    }
    
    public int getDX () {
        return dx;
    }

    public int getDY () {
        return dy;
    }
}
