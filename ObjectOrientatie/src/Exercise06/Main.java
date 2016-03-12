package Exercise06;

/**
 *
 * @author Pieter Koopman, Sjaak Smetsers
 */
public class Main
{

    public static void main(String[] args) {
        int [] game = {5,2,7, 1,3,8, 6,9,4}; // Hard test case
//        int [] game = {1,2,3, 9,5,6, 4,7,8}; // Easy test case

        SlidingGame s = new SlidingGame (game);
        System.out.println(s);
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}
