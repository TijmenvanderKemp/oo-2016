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
public class BlackLeaf implements QTNode{
    /**
     * empty constructor, because the leaf doesn't have any attributes
     */
    public BlackLeaf(){
        
    } 
    
    /**
     * fills a bitmap with a black leaf, so all black
     * @param x left top x-coordinate of the area you want to color
     * @param y left top y-coordinate of the area you want to color
     * @param width width of the area you want to color
     * @param bitmap bitmap you want to color
     */
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap){
        for(int i = x; i < x + width; i++){
            for(int j = y; j < y +width; j++){
                bitmap.setBit(i, j, false);
            }
        }
    }
    
    /**
     * writes the correct characters to a writer based on a black leaf
     * @param Out the writer to write to
     */
    @Override
    public void writeNode(Writer Out){
        try{
          Out.append("00");  
        }catch(IOException e){}
    }
}
