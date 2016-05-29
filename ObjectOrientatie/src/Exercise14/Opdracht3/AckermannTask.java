/*
 * Created by Joep Veldhoven and Tijmen van der Kemp for the course Object Orientation 2016
 * Joep Veldhoven - s4456556
 * Tijmen van der Kemp - s4446887
 */
package Exercise14.Opdracht3;

import javafx.application.Platform;
import javafx.concurrent.Task;

/**
 *
 * @author tijmen
 */
public class AckermannTask extends Task<String> {

    private int m, n;
    private String solution = "not calculated yet";
    private final AckermannFX afx;
    
    public AckermannTask (AckermannFX afx) {
        this.afx = afx;
        
    }
    
    public void setInputs (int m, int n) {
        this.m = m;
        this.n = n;
        
    }
    
    private int recursiveSolve (int m, int n) {
        if (isCancelled()) {
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
    protected String call() throws Exception {
        
        int solutionInt = recursiveSolve (m, n);
        if (solutionInt != -1) {
            solution = "" + solutionInt;
        }
        Platform.runLater(() -> {afx.setResultLabel(solution);});
        
        return solution;
    }
    
    
    
}
