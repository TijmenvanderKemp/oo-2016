package Exercise04;

/**
 * Klasse voor punten op de loipe
 * @author pieter koopman
 */
public class Punt {
    /**
     * de x- en y-coordinaat
     */
    private int x, y;

    /**
     * constructors
     */
    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Punt () {
        this(0, 0);
    }
    
    /**
     * copy constructor
     * @param p punt dat gekopieerd zal worden
     */
    public Punt (Punt p) {
        if (p != null) {
            x = p.x;
            y = p.y;
        } else {
            x = y = 0;
        }
    }
    
    /**
     * verander punt een stap in de gegeven richting
     * @param r 
     */
    public void stap (Richting r) {
        x += r.dx;
        y += r.dy;
    }
    
    /**
     * add the given point to this point
     * @param p point to be added
     * @return this point
     */
    public Punt add (Punt p) {
        x += p.x;
        y += p.y;
        return this;
    }
    
    /**
     * make a new point as the sum off this and parameter
     * @param p point to be added to this
     * @return new point
     */
    public Punt sum (Punt p) {
        return new Punt (x + p.x, y + p.y);
    }
    
    /**
     * getters
     */
    public int getX (){
        return x;
    }
    public int getY (){
        return y;
    }
    
    /**
     * equals method
     * @param o object to be compared with this point
     * @return true als argument gelijk is aan dit p unt
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Punt) {
            Punt p = (Punt) o;
            return x == p.x && y == p.y;
        } else {
            return false;
        }
    }
    /**
     * convert this punt to String
     * @return string representation of this point
     */
    @Override
    public String toString () {
        return "(" + x + "," + y + ")";
    }
}
