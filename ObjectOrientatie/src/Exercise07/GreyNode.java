/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package Exercise07;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Tijmen van der Kemp (s4446887)
 * @author Joep Veldhoven (s4456556)
 */
public class GreyNode implements QTNode{
    QTNode[] children; //list of its children
    
    /**
     * constructor for a greynode
     * @param c the list of children
     */
    public GreyNode(QTNode[] c){
        children = c;
    }
    
    /**
     * recursively fills a bitmap based on the children of the grey node
     * @param x left top x-coordinate of the area you want to color
     * @param y left top y-coordinate of the area you want to color
     * @param width width of the area you want to color
     * @param bitmap bitmap you want to color
     */
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap){
        children[0].fillBitmap(x, y, width/2, bitmap);
        children[1].fillBitmap(x+width/2, y, width/2, bitmap);
        children[2].fillBitmap(x+width/2, y+width/2, width/2, bitmap);
        children[3].fillBitmap(x, y+width/2, width/2, bitmap);
    }
    
    /**
     * Recursively writes the correct characters to a writer based on the children of the grey node
     * @param Out the writer to write to
     */
    @Override
    public void writeNode(Writer Out){
        try{
          Out.append("1");  
        }catch(IOException e){}
        children[0].writeNode(Out);
        children[1].writeNode(Out);
        children[2].writeNode(Out);
        children[3].writeNode(Out);        
    }
}
