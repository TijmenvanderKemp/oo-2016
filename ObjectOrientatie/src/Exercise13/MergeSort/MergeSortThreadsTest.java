/*
 * Created by Joep Veldhoven and Tijmen van der Kemp for the course Object Orientation 2016
 * Joep Veldhoven - s4456556
 * Tijmen van der Kemp - s4446887
 */
package Exercise13.MergeSort;

/**
 *
 * @author Tijmen van der Kemp s4446887 & Joep Veldhoven s4456556
 */

/**
 * Number of available processors: 8
 * 
 * Time elapsed in milliseconds:
 * 203 - No threads, THRESHOLD = 10E6
 * 143 - THRESHOLD = 10E5
 * 178 - THRESHOLD = 10E4
 * 353 - THRESHOLD = 10E3
 * 
 * So the optimal value is somewhere around 10E5
 * 
 * 172 - 5*10E5
 * 143 -   10E5
 * 151 - 7*10E4
 * 148 - 5*10E4
 */

public class MergeSortThreadsTest {
    
    private static final int SIZE = 1000000;
    
    public static void main(String[ ] args) {
        mergeSortThreadsTest( ) ;
    }

    public static void mergeSortThreadsTest( ) {
        try {
            System.out.println("The number of available processors is: " + 
                                Runtime.getRuntime().availableProcessors());
            
            int [] array = new int [SIZE];
            for (int i = 0; i < SIZE; i ++) {
                array[i] = (int) (Math.random() * Integer.MAX_VALUE);
            }
            
            // Start timing
            long currentTimeMillis = System.currentTimeMillis();
            
            MergeSortThreads mST = new MergeSortThreads(array) ;
            Thread t = new Thread(mST);
            t.start();
            t.join();
            array = mST.getArray();
//            This works, but it takes a lot of time. Uncomment it if you want to see the numbers.
//            for (int i : array) {
//                System.out.println(i);
//            }

            // Stop timing
            long newTimeMillis = System.currentTimeMillis();
            // The time difference in milliseconds.
            System.out.println("The elapsed time was: " + (newTimeMillis - currentTimeMillis) + " milliseconds");
            
        } catch (InterruptedException e) {
            e.printStackTrace( ) ;
        }
    }
}
