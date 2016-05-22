/*
 * Created by Joep Veldhoven and Tijmen van der Kemp for the course Object Orientation 2016
 * Joep Veldhoven - s4456556
 * Tijmen van der Kemp - s4446887
 */
package Exercise13.FileFinder;

import java.io.IOException;

/**
 *
 * @author Tijmen van der Kemp s4446887 & Joep Veldhoven s4456556
 */
public class FileFinderThreadsTest {
    
    public static void main(String[ ] args) {
        fileFinderTest( ) ;
    }

    public static void fileFinderTest( ) {
        try {
            String goal = "FileFinderThreads.java";
            String root = "C:\\";
            FileFinderThreads ff = new FileFinderThreads(root, goal) ;
            Thread t = new Thread(ff);
            t.start();
        } catch (IOException e) {
            e.printStackTrace( ) ;
        }
    }
}
