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
public interface InfoLoipe {
    public int getWidth( ) ; // groo t te in oost−west rich ting
    public int getHeight( ) ; // groo t te in noord−zuid rich ting
    public Fragment getFragment(Punt p) ; // fragment van de loipe op p o si tie p
    public Punt start( ) ; // Het s tar tpun t op de kaart
    public Punt stap( ) ; // het volgende punt op de route
}
