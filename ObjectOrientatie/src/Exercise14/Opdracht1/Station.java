/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package Exercise14.Opdracht1;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


/**
 * Class that holds the number of persons arriving by train at the station and
 * waiting for a taxi*
 */
public class Station {

    private volatile int nrOfPassengersAtStation;
    private int totalNrOfPassengers;
    private boolean isClosed;
    
    public Station(  ) {
        this.nrOfPassengersAtStation = 0;
        this.totalNrOfPassengers = 0;
        this.isClosed = false;
    }

    public void enterStation( int nrOfPassengers ) {
        nrOfPassengersAtStation += nrOfPassengers;
        totalNrOfPassengers += nrOfPassengers;
        System.out.println("Train with " + nrOfPassengers + " passengers has arrived");
    }
    /**
     * Ask for nrOfPassengers Passengers to leave the station
     * if there aren't any more passengers return 0 so the taxi doesn't take people that aren't there
     * @param nrOfPassengers
     * @return the number of passengers to actually leave
     */
    public synchronized int leaveStation( int nrOfPassengers ) {
        if (getNrOfPassengersWaiting() >= nrOfPassengers) {
            nrOfPassengersAtStation -= nrOfPassengers;
            return nrOfPassengers;
        }
        else {
            return 0;
        }
    }

    public synchronized int getNrOfPassengersWaiting() {
        return nrOfPassengersAtStation;
    }
    
    /**
     * closes the station, so no more trains will arrive
     */
    public void close() {
        isClosed = true;
    }
    
    public boolean isClosed() {
        return isClosed;     
    }

    public int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }


}