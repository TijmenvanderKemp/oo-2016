/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package opdracht14.taxirides;

/**
 *
 * @author Joep
 */


import java.util.Random;

public class Util {
  private static Random generator = new Random();

  /**
   * Generates a random number between from and to
   * 
   * @param from lower limit
   * @param to   upper limit
   * @return random number between from and to
   */
  public static int getRandomNumber(int from, int to) {
    if (from == to) {
      return from;
    }
    else {
      return from + generator.nextInt(to - from);
    }
  }
}
