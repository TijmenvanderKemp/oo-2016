/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise11;

import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class DocumentHandler {
    private final Document d;
    private final List<String> weerstations;
    
    public DocumentHandler (Document d) {
        this.d = d;
        NodeList ndl = d.getElementsByTagName("stationnaam");
        weerstations = new LinkedList<>();
        for (int i = 0; i < ndl.getLength(); i ++) {
            weerstations.add(ndl.item(i).getFirstChild().getNodeValue().substring(12));
        }
    }
    
    public List<String> getWeerstations () {
        return weerstations;
    }
    
    public List<String> getInfoAboutStation (String station) {
        /* String list of data:
            latitude
            longtitude
            datum
            luchtvochtigheid
            temperatuur (celsius)
            windsnelheid (m/s)
            windsnelheid (beaufort)
            windrichting (graden)
            windrichting (afkorting)
            luchtdruk
            zichtmeters
            windstoten (m/s)
            regen (mm/u)
            icoon
            temperatuur (10 cm)
        */
        List<String> data = new LinkedList<>();
        
        NodeList ndl = d.getElementsByTagName("stationnaam");
        for (int i = 0; i < ndl.getLength(); i ++) {
            // Find the one node with the name of what you entered in the dropdown box.
            if (ndl.item(i).getFirstChild().getNodeValue().substring(12).equals(station)) {
                
                // Go through all subsequent 15 nodes and write down the data in the List.
                Node dataNode = ndl.item(i);
                for (int gegevensindex = 0; gegevensindex < 15; gegevensindex ++) {
                    dataNode = dataNode.getNextSibling();
                    data.add(dataNode.getFirstChild().getNodeValue());
                }
                
            }
        }
        
        return data;
    }
}
