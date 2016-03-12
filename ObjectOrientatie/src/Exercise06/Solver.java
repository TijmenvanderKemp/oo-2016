// Part of Exercise 6 by Joep Veldhoven (s4456556) and Tijmen van der Kemp (s4446887)

package Exercise06;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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
    Collection<Configuration> examined;
    List<Node<Configuration>> path;

    public Solver( Configuration g ) {
        toExamine = new PriorityQueue<>();
        toExamine.add(g);
        
        examined = new HashSet();
        
        path = new LinkedList<>();
        path.add(new Node<> (null, g));
    }

    /**
     * A skeleton implementation of the solver
     *
     * @return a string representation of the solution
     */
    public String solve() {
        while ( ! toExamine.isEmpty() ) {
            Configuration next = toExamine.remove();
            examined.add(next);
            if ( next.isSolution() ) {
                return getCurrentNode(next).toString();
            } else {
                for ( Configuration succ : next.successors() ) {
                    if (!examined.contains(succ)) {
                        toExamine.add(succ);
                        
                        Node currentNode = getCurrentNode(next); 
                        path.add(new Node(currentNode, succ));
                    }
                }
            }
        }
        return "Failure!";
    }
    
    /**
     * gives the node equivalent to the node of the current configuration
     * @param next the configuration of which you should find the equivalent node
     * @return the equivalent nod to the configuration
     */
    private Node<Configuration> getCurrentNode (Configuration next) {
        Node currentNode = null;
        // Find the node equivalent to the current configuration
        for (Node n : path) {
            if (next.equals(n.getItem()))
                currentNode = n;
        }
        
        return currentNode;
    }

}
