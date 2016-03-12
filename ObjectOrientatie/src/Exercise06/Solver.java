package Exercise06;

import java.util.Queue;


/**
 * A class that implements a breadth-first search algorithm
 * for finding the Configurations for which the isSolution predicate holds
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.4
 * @date 07-03-2016
 */
public class Solver
{
    // A queue for maintaining graphs that are not visited yet.
    Queue<Configuration> toExamine;

    public Solver( Configuration g ) {
        throw new UnsupportedOperationException( "Solver: not supported yet." );
    }

    /**
     * A skeleton implementation of the solver
     *
     * @return a string representation of the solution
     */
    public String solve() {
        while ( ! toExamine.isEmpty() ) {
            Configuration next = toExamine.remove();
            if ( next.isSolution() ) {
                return "Success!";
            } else {
                for ( Configuration succ : next.successors() ) {
                    toExamine.add(succ);
                }
            }
        }
        return "Failure!";
    }

}
