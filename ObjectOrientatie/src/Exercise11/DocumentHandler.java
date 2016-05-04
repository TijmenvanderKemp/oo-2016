/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise11;

import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class DocumentHandler {
    Document d;
    List<String> weerstations;
    
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
    
    public void getInfoAboutStation (String station) {
        // IMPLEMENT
    }
}
