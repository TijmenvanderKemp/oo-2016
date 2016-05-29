/*
 * Created by Joep Veldhoven and Tijmen van der Kemp for the course Object Orientation 2016
 * Joep Veldhoven - s4456556
 * Tijmen van der Kemp - s4446887
 */
package Exercise14.Opdracht2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author tijmen
 */
public class AckermannModel implements Runnable {

    private int m, n;
    private String solution = "not calculated yet";
    private final AckermannFX afx;
    
    public AckermannModel (AckermannFX afx) {
        this.afx = afx;
        
    }
    
    public void setInputs (int m, int n) {
        this.m = m;
        this.n = n;
        
    }
    
    private int recursiveSolve (int m, int n) {
        if (Thread.interrupted()) {
            solution = "Interrupted";
            return -1;
        }
        else {
            if (n == -1) {
                return -1;
            }
            if (m == 0) {
                return (n + 1);
            }
            if (n == 0 && m > 0) {
                return recursiveSolve (m - 1, 1);
            }
            if (n > 0 && m > 0) {
                return recursiveSolve (m - 1,
                        recursiveSolve (m, n - 1));
            }
            else {
                return -1;
            }
        }
    }
    
    @Override
    public synchronized void run() {
        int solutionInt = recursiveSolve (m, n);
        if (solutionInt != -1) {
            solution = "" + solutionInt;
        }
        Platform.runLater(() -> {afx.setResultLabel(solution);});
    }
    
}
