/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package opdracht14.taxirides;

/**
 *
 * @author Joep
 */


public class Train {
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

  public void closeStation() {
    station.close();
  }

  public int getNrOfTrips() {
    return nrOfTrips;
  }

}
