/*
 * Created by Joep Veldhoven and Tijmen van der Kemp for the course Object Orientation 2016
 * Joep Veldhoven - s4456556
 * Tijmen van der Kemp - s4446887
 */
package Exercise13.MergeSort;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tijmen
 */
public class MergeSortThreads implements Runnable {
    
    private static final int THRESHOLD = 70000;
    private final int [] threadArray;
    
    public MergeSortThreads (int[] array) {
        threadArray = array;
    }
    
    /**
    * sort the given array in O(N log N) time
    * The array is split in to two parts of equal size.
    * These parts are sorted recursively and merged.
    * @param array
    * @throws java.lang.InterruptedException
    */
    public void sort (int [] array) throws InterruptedException {
        if (array.length > 1 ) {
            int[ ] firstHalf = Arrays.copyOf(array, array.length / 2 ) ;
            int[ ] secondHalf = Arrays.copyOfRange(array, array.length / 2 , array.length) ;
            
            if (firstHalf.length < THRESHOLD) {
                sort(firstHalf) ;
                sort(secondHalf) ;
                merge(firstHalf, secondHalf, array) ;
            } else {
                MergeSortThreads mST1 = new MergeSortThreads(firstHalf);
                MergeSortThreads mST2 = new MergeSortThreads(secondHalf);
                Thread t1 = new Thread(mST1);
                Thread t2 = new Thread(mST2);
                t1.start();
                t2.start();
                // When we call mST?.getArray, we ask up the current "array" of that object.
                // We have to call t1.join and t2.join to make sure the threads are finished,
                // so they are in the sorted state.
                t1.join();
                t2.join();
                merge(mST1.getArray(), mST2.getArray(), threadArray);

            } 
        }
    }
    
    /**
     * @return The current array.
     */
    public int [] getArray () {
        return threadArray;
    }
    
    /**
    * merge two sorted arrays : O(N)
    * @param part1 a sorted array
    * @param part2 a sorted array
    * @param dest destination , length must be >= part1 . length + part2 . length
    */
    public static void merge( int[ ] part1, int[ ] part2, int[ ] dest) {
        int part1Index = 0 , part2Index = 0 , destIndex = 0;
        while (part1Index < part1.length && part2Index < part2.length) {
            if (part1[part1Index] < part2[part2Index] )
                dest[destIndex ++] = part1[part1Index ++];
            else
                dest[destIndex ++] = part2[part2Index ++];
        }
        while (part1Index < part1.length)
            dest[destIndex ++] = part1[part1Index ++];
        while (part2Index < part2.length)
            dest[destIndex ++] = part2[part2Index ++];
    }

    @Override
    public void run() {
        try {
            sort(threadArray);
        } catch (InterruptedException ex) {
            Logger.getLogger(MergeSortThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
