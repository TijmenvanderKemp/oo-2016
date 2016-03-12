package Exercise06;

import java.util.Collection;


/**
 * An interface for representing nodes in a state space.
 * 
 * @author Sjaak Smetsers
 * @version 1.3
 * @date 07-03-2016
 */
public interface Configuration extends Comparable<Configuration>
{
    /**
     * To obtain the successors for a specific configuration
     *
     * @return a collection of configurations containing the successors
     */
    public Collection<Configuration> successors();

    /**
     * For marking final / solution configurations.
     */
    public boolean isSolution();
    
    /**
     * For comparing manhattans.
     */
    public int getManhattan();
    
    /**
     * For setting manhattans.
     */
    public void setManhattan(int m);
}
