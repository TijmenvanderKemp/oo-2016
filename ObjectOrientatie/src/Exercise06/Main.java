package Exercise06;

/**
 *
 * @author Pieter Koopman, Sjaak Smetsers
 */
public class Main
{

    public static void main(String[] args) {
        int [] game = {4,6,8, 9,2,1, 3,7,5}; // Hard test case -- my computer solves this in 4 minutes and 10 seconds.
//        int [] game = {1,2,3, 9,5,6, 4,7,8}; // Easy test case -- my computer solves this within a second.

        SlidingGame s = new SlidingGame (game);
        s.calculateManhattan();
        System.out.println(s);
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}
