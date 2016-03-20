/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package Exercise07;

/**
 *
 * @author Joep
 */
public class BlackLeaf implements QTNode{
    public BlackLeaf(){
        
    } 
    
    
    public void fillBitmap(int x, int y, int width, Bitmap bitmap){
        for(int i = x; i < x + width; i++){
            for(int j = y; j < y +width; j++){
                bitmap.setBit(x, y, false);
            }
        }
    }
}
