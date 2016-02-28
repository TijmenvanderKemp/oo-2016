/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise04;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Richting {
    /** 
     * Een richting in de vorm van een verandering van de x- en y-coordinaat
     */
    public final int dx, dy;
    
    /**
     * constructor voor een richting
     * @param dx verandering van de x-coordinaat
     * @param dy verandering van de y-coordinaat
     */
    public Richting (int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
