/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package Exercise14.Opdracht1;

import static Exercise14.Opdracht1.Simulation.MAX_TRAVELLERS;
import static Exercise14.Opdracht1.Simulation.MIN_TRAVELLERS;
import static Exercise14.Opdracht1.Simulation.TRAIN_TRIPS;

/**
 *
 * @author Joep
 */


public class Train implements Runnable{
  private int nrOfPassengers;
  private final Station station;
  private int nrOfTrips = 0;

  public Train(Station station) {
    this.station = station;
    this.nrOfPassengers = 0;
  }

  /**
   * Populate this train with number nrOfPassengers
   *
   * @param number
   *          the number of passenegers of this train
   */
  public void getIn(int number) {
    nrOfPassengers = number;
  }

  /**
   * empties this train and augment the number of Passengers at the station with
   * this nrOfPassenegers
   */
  public void getOff() {
    nrOfTrips += 1;
    station.enterStation(nrOfPassengers);
  }

  /**
   * closes the station, so no more trains will arrive there.
   */
  public void closeStation() {
    station.close();
  }

  public int getNrOfTrips() {
    return nrOfTrips;
  }

    @Override
    public void run() {
        if (nrOfTrips < TRAIN_TRIPS && !(station.getNrOfPassengersWaiting() > 0)) {
            getIn(Util.getRandomNumber(MIN_TRAVELLERS, MAX_TRAVELLERS));
            getOff();
        }
        else
            closeStation();
    }

}
