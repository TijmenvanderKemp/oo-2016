/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht1;

/**
 * De yoghurtijs klasse. Een subklasse van IJsje.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class YoghurtIJs extends IJsje {
    
    public YoghurtIJs () {
        beschrijving = "Een yoghurtijsje";
    }

    @Override
    public int prijs() {
        return 200;
    }

}
