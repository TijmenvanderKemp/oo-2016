/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht1;

/**
 * Dit is de belangrijkste klasse in het Decorator pattern.
 * Dit is een IJsje-decorator, dus dit is een subklasse van IJsje.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public abstract class IJsjesDecoratie extends IJsje {
    
    protected final IJsje ijsje;
    
    public IJsjesDecoratie (IJsje ijsje) {
        this.ijsje = ijsje;
    }
    
    @Override
    public int prijs () { 
        return ijsje.prijs(); 
    }
    
}
