package Exercise07;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Tijmen van der Kemp (s4446887)
 * @author Joep Veldhoven (s4456556)
 */

public class Qtrees {

    public static void main(String[] args) {
        String test_tekst = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_tekst);
        QTree qt = new QTree( input );
        Bitmap bitmap = new Bitmap(8, 8);
        qt.fillBitmap( bitmap );
        System.out.println(bitmap);
        QTree newqt = new QTree (bitmap);
        StringWriter outputBuffer = new StringWriter();
        newqt.writeQTree(outputBuffer);
        System.out.println(outputBuffer);
    }

}
