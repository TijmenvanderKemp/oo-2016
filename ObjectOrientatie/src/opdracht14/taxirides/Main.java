/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package opdracht14.taxirides;

/**
 *
 * @author Joep
 */


public class Main {
  public static void main(String[] args) {
    Simulation sim = new Simulation();
    while (!sim.ended()) {
      sim.step();
    }
    sim.showStatistics();
  }
}

