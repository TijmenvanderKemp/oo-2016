
package exercise15;

/**
 *
 * @author Joep Veldhoven s4456556, Tijmen van der Kemp s4446887
 */


public class Crossroads {
    private final Car c0,c1,c2,c3; // cars on the crossroad
    private final Zone z0,z1,z2,z3; // zones of the crossroad
    
    public static void main(String[] args){
        Crossroads c = new Crossroads();
        c.start();
    }
    
    public Crossroads(){
        z0 = new Zone(0);
        z1 = new Zone(1);
        z2 = new Zone(2);
        z3 = new Zone(3);
        c0 = new Car(0,z0,z1,z2);
        c1 = new Car(1,z1,z2,z3);
        c2 = new Car(2,z2,z3,z0);
        c3 = new Car(3,z3,z0,z1);
    }
    
    public void start(){
        new Thread(c0).start();
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();        
    }
}
