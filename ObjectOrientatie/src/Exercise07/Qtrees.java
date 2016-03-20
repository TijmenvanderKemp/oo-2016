package Exercise07;

import java.io.StringReader;

public class Qtrees {

    public static void main(String[] args) {
        String test_tekst = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_tekst);
        QTree qt = new QTree( input );
        Bitmap bitmap = new Bitmap(8, 8);
        qt.fillBitmap( bitmap );
        System.out.println(bitmap);
    }

}
