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
public class Loipe implements InfoLoipe {
    
    private int width;
    private int height;
    private Fragment [][] loipe;
    private ArrayList<Punt> loipeList = new ArrayList();
    private Punt startPunt;
    private int stepCounter;
    
    // grootte in oost−west richting
    @Override
    public int getWidth( ) {
        return width;
    } 
    
    // grootte in noord−zuid richting
    @Override
    public int getHeight( ) {
        return height;
    }
    
    // fragment van de loipe op positie p
    @Override
    public Fragment getFragment(Punt p) {
        return loipe[p.getX()][p.getY()];
    }
    
    // Het startpunt op de kaart
    @Override
    public Punt start( ) {
        return startPunt;
    } 
    
    // het volgende punt op de route
    @Override
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
        int dir = 0; // 0 = N, 1 = O, 2 = Z, 3 = W
        for (int i = 0; i < pad.length(); i ++) {
            switch (pad.charAt(i)) {
                case 'l':
                    dir = (dir + 3) % 4;
                    break;
                case 'r':
                    dir = (dir + 1) % 4;
                    break;
                case 's':
                    break;
            }
            
            switch (dir) {
                case 0:
                    y -= 1;
                    break;
                case 1:
                    x += 1;
                    break;
                case 2:
                    y += 1;
                    break;
                case 3:
                    x -= 1;
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
        
        loipe = new Fragment[width][height];
        
        x = startPunt.getX();
        y = startPunt.getY();
        stepCounter = 0;
        loipeList.add(new Punt(x, y));
        dir = 0; // 0 = N, 1 = O, 2 = Z, 3 = W
        for (int i = 0; i < pad.length(); i ++) {
            switch (pad.charAt(i)) {
                case 'l':
                    switch (dir) {
                        case 0:
                            loipe[x][y] = Fragment.ZW;
                            break;
                        case 1:
                            loipe[x][y] = Fragment.NW;
                            break;
                        case 2:
                            loipe[x][y] = Fragment.NO;
                            break;
                        case 3:
                            loipe[x][y] = Fragment.ZO;
                            break;
                    }
                    dir = (dir + 3) % 4;
                    break;
                case 'r':
                    switch (dir) {
                        case 0:
                            loipe[x][y] = Fragment.ZO;
                            break;
                        case 1:
                            loipe[x][y] = Fragment.ZW;
                            break;
                        case 2:
                            loipe[x][y] = Fragment.NW;
                            break;
                        case 3:
                            loipe[x][y] = Fragment.NO;
                            break;
                    }
                    dir = (dir + 1) % 4;
                    break;
                case 's':
                    if (loipe[x][y] == Fragment.OW || loipe[x][y] == Fragment.NZ) {
                        loipe[x][y] = Fragment.KR;
                    }
                    else if (dir == 0 || dir == 2) {
                        loipe[x][y] = Fragment.NZ;
                    }
                    else {
                        loipe[x][y] = Fragment.OW;
                    }
                    break;
            }
            
            switch (dir) {
                case 0:
                    y -= 1;
                    break;
                case 1:
                    x += 1;
                    break;
                case 2:
                    y += 1;
                    break;
                case 3:
                    x -= 1;
                    break;
            }
            
            loipeList.add(new Punt(x, y));
        }
        
    }

}
