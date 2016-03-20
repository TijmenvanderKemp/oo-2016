package Exercise07;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class QTree {
    QTNode root;
//    static String inputString;
    
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
//        inputString = input.toString();
        return recursiveQTreeFill (input);
    }
    
    private static QTNode recursiveQTreeFill( Reader inputString ) {
        QTNode currentNode;
        
        int nodeLeafBit = '0';
        try {
            nodeLeafBit = inputString.read();
        } catch (IOException ioe) {
            System.out.println ("Provided string is not formatted correctly.\n Details: " + ioe);
        }
        if (nodeLeafBit == '0') { // Leaf
            int colorBit = '0';
            try {
                colorBit = inputString.read();
            } catch (IOException ioe) {
                System.out.println ("Provided string is not formatted correctly.\n Details: " + ioe);
            }
            if (colorBit == '0') {
                currentNode = new BlackLeaf ();
            }
            else {
                currentNode = new WhiteLeaf ();
            }
        }
        else { // Grey Node
            QTNode [] children = new QTNode [4];
            for (int i = 0; i < 4; i ++) {
                children [i] = recursiveQTreeFill( inputString );
            }
            currentNode = new GreyNode (children);
        }
        
        return currentNode;
    }
    
    public static QTNode bitmap2QTree( int x, int y, int width, Bitmap bitmap ) {
        int depth = 1;
        while(width > 1) {
            width = width / 2;
            depth ++;
        }
        
        return null;
    }

}
