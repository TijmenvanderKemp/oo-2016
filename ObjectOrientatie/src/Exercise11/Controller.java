/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise11;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Controller {

    DocumentBuilderFactory dBF;
    DocumentBuilder dB;
    Document d;
    DocumentHandler dH;
    View view;
    
    public Controller () {
        dBF = DocumentBuilderFactory.newInstance();
        try {
            dB = dBF.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, "Couldn't create a DocumentBuilder with this configuration.", ex);
        }
        getBuienradar();
        
        List<String> weerstations = dH.getWeerstations();
        for (String s : weerstations) {
            System.out.println(s);
        }
        
        System.out.println();
        
        List<String> data = dH.getInfoAboutStation("Arnhem");
        for (String s : data) {
            System.out.println(s);
        }
        
        view = new View();
        view.addController(this);
    }
    
    private void getBuienradar () {
        try {
            d = dB.parse("http://xml.buienradar.nl");
        } catch (SAXException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, "Error parsing this file. Take a look at the XML.", ex);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, "Error in I/O. Maybe your internet is down?", ex);
        }
        dH = new DocumentHandler(d);
    }
    
    public void refreshDocument() {
        getBuienradar();
    }
}
