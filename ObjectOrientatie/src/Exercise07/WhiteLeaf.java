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
public class WhiteLeaf implements QTNode {
    public WhiteLeaf(){
        
    }
            
    public void fillBitmap(int x, int y, int width, Bitmap bitmap){
        for(int i = x; i < x + width; i++){
            for(int j = y; j < y + width; j++){
                bitmap.setBit(i, j, true);
            }
        }
    }
    
    public void writeNode(Writer Out){
        try{
          Out.append("01");  
        }catch(IOException e){}
    }
}
