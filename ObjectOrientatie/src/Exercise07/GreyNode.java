/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package Exercise07;

/**
 *
 * @author Joep
 */
public class GreyNode implements QTNode{
    QTNode child1, child2, child3, child4;
    public GreyNode(QTNode c1, QTNode c2, QTNode c3, QTNode c4){
        child1 = c1;
        child2 = c2;
        child3 = c3;
        child4 = c4;
    }
    public void fillBitmap(int x, int y, int width, Bitmap bitmap){
        child1.fillBitmap(x, y, width/2, bitmap);
        child2.fillBitmap(x+width/2, y, width/2, bitmap);
        child3.fillBitmap(x+width/2, y+width/2, width/2, bitmap);
        child4.fillBitmap(x, y+width/2, width/2, bitmap);
    }
}
