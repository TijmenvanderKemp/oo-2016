/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise11;

import javax.swing.text.Document;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Controller {

    DocumentBuilderFactory dBF;
    DocumentBuilder dB;
    Document d;
    View view;
    
    public Controller () {
        dBF = new DocumentBuilderFactory();
        dB = dBF.newDocumentBuilder();
        d = dB.parse();
        view = new View();
        view.addController(this);
    }
}
