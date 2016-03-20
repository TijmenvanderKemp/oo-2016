package Exercise07;

import java.io.Reader;
import java.io.Writer;

public class QTree {
    QTNode root;
    
    public QTree( Reader input ) {
        root = readQTree( input );
    }
    
    public QTree( Bitmap bitmap ) {
        root = bitmap2QTree( 0, 0,  bitmap.getWidth(), bitmap );
    }

    public void fillBitmap ( Bitmap bitmap ) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    public void writeQTree( Writer sb ) {
        root.writeNode( sb );
    }
    
    private static QTNode readQTree( Reader input ) {
        QTNode tempRoot = new WhiteLeaf();
        
        return tempRoot;
    }
    
    public static QTNode bitmap2QTree( int x, int y, int width, Bitmap bitmap ) {
        return null;
    }

}
