package Exercise07;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * A Quad-tree class. Holds all the relevant information to build your own quad tree.
 * @author Tijmen van der Kemp (s4446887)
 * @author Joep Veldhoven (s4456556)
 */

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
    
    /**
     * Recursively parses a string and constructs a QTree out of it.
     * @param inputString The string with bits
     * @return The QTree
     */
    private static QTNode readQTree( Reader inputString ) {
        QTNode currentNode;
        
        // This node makes the difference between creating a node or a leaf
        int nodeLeafBit = readReader (inputString);
        
        if (nodeLeafBit == '0') { // Leaf
            int colorBit = readReader (inputString);
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
     * Reads an integer from a Reader object and returns it. Included the IOE.
     * @param input the Reader object.
     * @return the integer read.
     */
    private static int readReader ( Reader input ) {
        try {
            int returnInteger = input.read();
            return returnInteger;
        } catch (IOException ioe) {
            System.out.println ("Provided string is not formatted correctly.\n Details: " + ioe);
            return 0;
        }
    }
    
    /**
     * The basic idea is to divide the quad tree into all grey nodes until the
     * last layer, then fill it in pixel by pixel. On the way up, replace a grey
     * node with four black or white leaves with one leaf of that colour.
     * @param x the x position of the current quadrant
     * @param y the y position ,,  ,,    ,,      ,,
     * @param width the width  ,,  ,,    ,,      ,,
     * @param bitmap the bitmap get the pixels out of
     * @return the QTree derived from the bitmap
     */
    public static QTNode bitmap2QTree( int x, int y, int width, Bitmap bitmap ) {
        QTNode currentNode;
        
        // The bitmap is not fully divided up.
        if (width > 1) {
            QTNode [] children = new QTNode [4];
            int hw = width/2; // half width
            // Set the children to the four quadrants of the current bitmap
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
    
    /**
     * Checks whether all nodes of a Quad tree are of the same class.
     * @param nodes can be white, grey or black.
     * @return 
     */
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
