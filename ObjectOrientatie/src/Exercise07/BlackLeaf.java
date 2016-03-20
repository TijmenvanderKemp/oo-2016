/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package Exercise07;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author Joep
 */
public class BlackLeaf implements QTNode{
    public BlackLeaf(){
        
    } 
    
    
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap){
        for(int i = x; i < x + width; i++){
            for(int j = y; j < y +width; j++){
                bitmap.setBit(i, j, false);
            }
        }
    }
    
    @Override
    public void writeNode(Writer Out){
        try{
          Out.append("00");  
        }catch(IOException e){}
    }
}
