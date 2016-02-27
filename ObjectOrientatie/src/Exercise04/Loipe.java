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
                case 'r':
                    dir = (dir - 1) % 4;
                case 's':
            }
            
            switch (dir) {
                case 0:
                    x += 1;
                case 1:
                    y -= 1;
                case 2:
                    x -= 1;
                case 3:
                    y += 1;
            }
            
            minX = (x < minX) ? x : minX;
            minY = (y < minY) ? y : minY;
            maxX = (x > maxX) ? x : maxX;
            maxY = (y > maxY) ? y : maxY;
        }
        
        width = maxX - minX;
        height = maxY - minY;
        startPunt = new Punt(0 - minX, 0 - minY);
        
        loipe = new Fragment[height][width];
        
        x = startPunt.getX();
        y = startPunt.getY();
        stepCounter = 0;
        dir = 0; // 0 = E, 1 = N, 2 = W, 3 = S
        for (int i = 0; i < pad.length(); i ++) {
            switch (pad.charAt(i)) {
                case 'l':
                    switch (dir) {
                        case 0:
                            loipe[y][x] = Fragment.NW;
                        case 1:
                            loipe[y][x] = Fragment.ZW;
                        case 2:
                            loipe[y][x] = Fragment.ZO;
                        case 3:
                            loipe[y][x] = Fragment.NO;
                    }
                    dir = (dir + 1) % 4;
                case 'r':
                    switch (dir) {
                        case 0:
                            loipe[y][x] = Fragment.ZW;
                        case 1:
                            loipe[y][x] = Fragment.NW;
                        case 2:
                            loipe[y][x] = Fragment.NO;
                        case 3:
                            loipe[y][x] = Fragment.ZO;
                    }
                    dir = (dir - 1) % 4;
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
            }
            
            switch (dir) {
                case 0:
                    x += 1;
                case 1:
                    y -= 1;
                case 2:
                    x -= 1;
                case 3:
                    y += 1;
            }
            
            loipeList.add(new Punt(x, y));
        }
        
    }

}
