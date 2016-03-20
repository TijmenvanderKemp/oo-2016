package Exercise07;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Tijmen van der Kemp (s4446887)
 * @author Joep Veldhoven (s4456556)
 */

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
    
    private static QTNode readQTree( Reader inputString ) {
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
                children [i] = readQTree( inputString );
            }
            currentNode = new GreyNode (children);
        }
        
        return currentNode;
    }
    
    /**
     * The basic idea is to divide the quad tree into all grey nodes until the
     * last layer, then fill it in pixel by pixel. Then do anohter run through
     * to see if we can optimize 4 leafs of the same color into one leaf.
     */
    public static QTNode bitmap2QTree( int x, int y, int width, Bitmap bitmap ) {
        QTNode currentNode;
        
        // The bitmap is not fully divided up.
        if (width > 1) {
            QTNode [] children = new QTNode [4];
            int hw = width/2; // half width
            children [0] = bitmap2QTree (x     , y     , hw, bitmap);
            children [1] = bitmap2QTree (x + hw, y     , hw, bitmap);
            children [2] = bitmap2QTree (x + hw, y + hw, hw, bitmap);
            children [3] = bitmap2QTree (x     , y + hw, hw, bitmap);
            currentNode = new GreyNode (children);
            
            // Replace all four child nodes with one parent node if they are of
            // the same class.
            if (allChildrenSameColor(children)) {
                if (children[0].getClass() == BlackLeaf.class) {
                    currentNode = new BlackLeaf();
                }
                if (children[0].getClass() == WhiteLeaf.class) {
                    currentNode = new WhiteLeaf();
                }
            }
        }
        // This is the lowest we can go, so directly query the pixel.
        else {
            if (bitmap.getBit(x, y) == false) {
                currentNode = new BlackLeaf();
            }
            else {
                currentNode = new WhiteLeaf();
            }
        }
        
        
        return currentNode;
    }
    
    private static boolean allChildrenSameColor (QTNode [] nodes) {
        boolean same = true;
        for (int i = 0; i < nodes.length - 1; i ++) {
            if (!nodes[i].getClass().equals(nodes[i+1].getClass())) {
                same = false;
            }
        }
        return same;
    }

}
