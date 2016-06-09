 
package exercise15;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Joep Veldhoven s4456556, Tijmen van der Kemp s4446887
 */


public class Car implements Runnable{
    Random random;
    int number;
    Zone [] zones;
    public Car(int n, Zone z1, Zone z2, Zone z3){
        random = new Random();
        number = n;
        zones = new Zone[3];
        zones[0] = z1;
        zones[1] = z2;
        zones[2] = z3;
    }
    
    @Override
    public void run(){
        try{
            while(true){
                int direction = random.nextInt(3);
                Direction d = Direction.values()[direction];
                Zone [] used = new Zone[direction];
                for(int i = 0; i < direction; i ++){
                    used[i] = zones[i];
                } 
                used = sortByNumber(used);
                for (Zone used1 : used) {
                    used1.rijOp();
                }
                System.out.println("Car " + number + " goes " + d);
                Thread.sleep(random.nextInt(500));
                for(Zone used1 : used) {
                    used1.rijAf();
                }
            }
        } catch (InterruptedException ie) {
            System.out.println("Car " + number + " has crashed.") ;
        }
    }
    
    /**
     * use bubble sort to sort an array of zones by numbers
     * @param z the array to be sorted
     * @return the sorted array
     */
    public Zone[] sortByNumber(Zone[] z){
        for(int i = 0; i < z.length; i++){
            for(int j = i + 1; j < z.length; j++){
                if (z[j].getNummer() < z[i].getNummer()){
                    Zone dummy = z[j];
                    z[j] = z[i];
                    z[i] = dummy;
                }
            }
        }
        return z;
    }
}
