/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise04;

import java.util.ArrayList;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Loipe {
    
    private int width;
    private int height;
    private Fragment [][] loipe;
    private ArrayList<Punt> loipeList = new ArrayList();
    private Punt startPunt;
    private int stepCounter;
    
    // grootte in oost−west richting
    public int getWidth( ) {
        return width;
    } 
    
    // grootte in noord−zuid richting
    public int getHeight( ) {
        return height;
    }
    
    // fragment van de loipe op positie p
    public Fragment getFragment(Punt p) {
        return loipe[p.getY()][p.getX()];
    }
    
    // Het startpunt op de kaart
    public Punt start( ) {
        return startPunt;
    } 
    
    // het volgende punt op de route
    public Punt stap( ) {
        stepCounter ++;
        if (stepCounter >= loipeList.size())
            stepCounter = 0;
        return loipeList.get(stepCounter);
    } 
    
    public Loipe (String pad) {
        
        int minX = 0;
        int minY = 0;
        int maxX = 0;
        int maxY = 0;
        int x = 0;
        int y = 0;
        int dir = 0; // 0 = E, 1 = N, 2 = W, 3 = S
        for (int i = 0; i < pad.length(); i ++) {
            switch (pad.charAt(i)) {
                case 'l':
                    dir = (dir + 1) % 4;
                    break;
                case 'r':
                    dir = (dir + 3) % 4;
                    break;
                case 's':
                    break;
            }
            
            switch (dir) {
                case 0:
                    x += 1;
                    break;
                case 1:
                    y -= 1;
                    break;
                case 2:
                    x -= 1;
                    break;
                case 3:
                    y += 1;
                    break;
            }
            
            minX = Math.min (x, minX);
            minY = Math.min (y, minY);
            maxX = Math.max (x, maxX);
            maxY = Math.max (y, maxY);
        }
        
        width = maxX - minX + 1;
        height = maxY - minY + 1;
        startPunt = new Punt(0 - minX, 0 - minY);
        
        loipe = new Fragment[height][width];
        
        x = startPunt.getX();
        y = startPunt.getY();
        stepCounter = 0;
        loipeList.add(new Punt(x, y));
        dir = 0; // 0 = E, 1 = N, 2 = W, 3 = S
        for (int i = 0; i < pad.length(); i ++) {
            switch (pad.charAt(i)) {
                case 'l':
                    switch (dir) {
                        case 0:
                            loipe[y][x] = Fragment.NW;
                            break;
                        case 1:
                            loipe[y][x] = Fragment.ZW;
                            break;
                        case 2:
                            loipe[y][x] = Fragment.ZO;
                            break;
                        case 3:
                            loipe[y][x] = Fragment.NO;
                            break;
                    }
                    dir = (dir + 1) % 4;
                    break;
                case 'r':
                    switch (dir) {
                        case 0:
                            loipe[y][x] = Fragment.ZW;
                            break;
                        case 1:
                            loipe[y][x] = Fragment.ZO;
                            break;
                        case 2:
                            loipe[y][x] = Fragment.NO;
                            break;
                        case 3:
                            loipe[y][x] = Fragment.NW;
                            break;
                    }
                    dir = (dir + 3) % 4;
                    break;
                case 's':
                    if (loipe[y][x] == Fragment.OW || loipe[y][x] == Fragment.NZ) {
                        loipe[y][x] = Fragment.KR;
                    }
                    else if (dir == 0 || dir == 2) {
                        loipe[y][x] = Fragment.OW;
                    }
                    else {
                        loipe[y][x] = Fragment.NZ;
                    }
                    break;
            }
            
            switch (dir) {
                case 0:
                    x += 1;
                    break;
                case 1:
                    y -= 1;
                    break;
                case 2:
                    x -= 1;
                    break;
                case 3:
                    y += 1;
                    break;
            }
            
            loipeList.add(new Punt(x, y));
        }
        
    }

}
