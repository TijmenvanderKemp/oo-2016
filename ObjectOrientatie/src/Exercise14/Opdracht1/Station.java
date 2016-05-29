/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package Exercise14.Opdracht1;

/**
 *
 * @author Joep
 */


/**
 * Class that holds the number of persons arriving by train at the station and
 * waiting for a taxi*
 */
public class Station {

    private int nrOfPassengersAtStation;
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
     *
     * @param nrOfPassengers
     */
    public void leaveStation( int nrOfPassengers ) {
        nrOfPassengersAtStation -= nrOfPassengers;
    }

    public int getNrOfPassengersWaiting() {
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