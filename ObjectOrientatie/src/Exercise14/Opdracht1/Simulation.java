/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package Exercise14.Opdracht1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joep
 */


public class Simulation {


    public static final int CAPACITYSMALL = 4;
    public static final int CAPACITYLARGE = 7;
    public static final int TIMESMALL = 2;
    public static final int TIMELARGE = 3;
    public static final int NROFTAXIS = 4;
    public static final int NROFSMALLTAXIS = 2;

    private final Taxi[] taxis;
    private final Thread[] taxiThreads;
    private final Train train;
    private final Station station;

    private final boolean hasEnded = false;

    public Simulation() {
        station = new Station();

        
        taxis = new Taxi[NROFTAXIS];
        taxiThreads = new Thread[NROFTAXIS];
        for (int i = 0; i < NROFTAXIS; i++) {
            taxis[i] =
                i < NROFSMALLTAXIS ?
                    new Taxi(i + 1, CAPACITYSMALL, TIMESMALL, station) :
                    new Taxi(i + 1, CAPACITYLARGE, TIMELARGE, station);
            taxiThreads[i] = new Thread(taxis[i]);
            taxiThreads[i].start();
        }
        
        train = new Train(station);
        new Thread(train).start();
        
        for (Thread t : taxiThreads) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean ended() {
    return hasEnded;
    }

    /**
    * shows all the statistics of the simulation
    */
    public void showStatistics() {
    System.out.println("All persons have been transported");
    System.out.println("Total time of this simulation:" + calcTotalTime(taxis));
    System.out.println("Total nr of train travellers:" + station.getTotalNrOfPassengers());
    System.out.println("Total nr of persons transported in this simulation:" + calcTotalNrOfPassengers(taxis));
    }

    /**
    * Calculates the total time of the simulation by looping over all taxis
    *
    * @param taxis
    * @return total time
    */
    private static int calcTotalTime(Taxi[] taxis) {
        int time = 0;
        for (Taxi taxi : taxis) {
            time = time + taxi.calcTotalTime();
        }
        return time;
    }

    /**
    * Calculates the total number of passengers that has been transported by
    * looping over all taxis
    *
    * @param taxis
    * @return total number of passengers
    */
    private static int calcTotalNrOfPassengers(Taxi[] taxis) {
        int total = 0;
        for (Taxi taxi : taxis) {
            total += taxi.getTotalNrOfPassengers();
        }
        return total;
  }

}

