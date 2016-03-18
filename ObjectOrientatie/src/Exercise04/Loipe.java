/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise04;

import java.util.ArrayList;

/**
 * Holds the important information of the loipe. Basically the 2d array with all the pieces.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Loipe implements InfoLoipe {
    
    private int width;
    private int height;
    private Fragment [][] loipe;
    // We made an ArrayList with which we fill the loipe. This is efficient
    // because we need to loop through it and this way we avoid messy switches.
    private ArrayList<Punt> loipeList = new ArrayList();
    private Punt startPunt;
    private int stepCounter = 0;
    
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
    
    /**
     * Constructor with the main logic.
     * @param pad The text string that signifies the path. For example, "sssrssslrss"
     */
    public Loipe (String pad) {
        
        int [] boundaries = calculateBoundaries (pad);
        int minX = boundaries[0],
            minY = boundaries[1],
            maxX = boundaries[2],
            maxY = boundaries[3];
        
        // Calculate the width, height and starting point of the loipe itself.
        width = maxX - minX + 1;
        height = maxY - minY + 1;
        startPunt = new Punt(0 - minX, 0 - minY);
        
        loipe = new Fragment[width][height];
        
        // We can now start filling the loipe.
        fillLoipe(pad);
        
    }
    
    private int [] calculateBoundaries (String pad) {
        // Boundaries so we know the dimensions
        int minX = 0, minY = 0, maxX = 0, maxY = 0;
        int x = 0, y = 0;
        // 0 = N, 1 = O, 2 = Z, 3 = W
        int dir = 0; 
        // Loop through every letter of the path. First change direction,
        // then take a step.
        for (int i = 0; i < pad.length(); i ++) {
            int[] positionInfo = stepLoipe(x, y, dir, pad.charAt(i));
            x = positionInfo[0];
            y = positionInfo[1];
            dir = positionInfo[2];
            
            // Push out the boundaries if necessary.
            minX = Math.min (x, minX);
            minY = Math.min (y, minY);
            maxX = Math.max (x, maxX);
            maxY = Math.max (y, maxY);
        }
        
        return new int[]{
            minX,
            minY,
            maxX,
            maxY
        };
    }
    
    private void fillLoipe(String pad){
        int x = startPunt.getX();
        int y = startPunt.getY();
        loipeList.add(new Punt(x, y));
        int dir = 0; // 0 = N, 1 = O, 2 = Z, 3 = W
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
            
            int[] positionInfo = stepLoipe(x, y, dir, pad.charAt(i));
            x = positionInfo[0];
            y = positionInfo[1];
            dir = positionInfo[2];
            
            
            loipeList.add(new Punt(x, y));
        }
    }
    
    private int [] stepLoipe (int x, int y, int dir, char dirChar) {
        
        // Update the direction we are going in
        switch (dirChar) {
            case 'l':
                dir = (dir + 3) % 4;
                break;
            case 'r':
                dir = (dir + 1) % 4;
                break;
            case 's':
                break;
        }
        
        // Take a step in the new direction
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
        return new int[] {x, y, dir};
        
    }

}
