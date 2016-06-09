
package exercise15;

/**
 *
 * @author Joep Veldhoven s4456556, Tijmen van der Kemp s4446887
 */


public class Zone {
    private boolean occupied;
    private int nummer;
    
    public Zone(int n){
        occupied = false;
        nummer = n;
    }
    
    /**
     * wordt aangeroepen als een auto een zone op wil rijden
     * @throws InterruptedException 
     */
    public synchronized void rijOp() throws InterruptedException{
        while(occupied){
            wait();
        }
        occupied = true;
    }
    
    public synchronized void rijAf() throws InterruptedException{
        occupied = false;
        notifyAll();
    }
    
    public int getNummer(){
        return nummer;
    }
}
