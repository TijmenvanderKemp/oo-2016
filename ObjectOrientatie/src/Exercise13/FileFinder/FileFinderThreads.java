/*
 * Created by Joep Veldhoven and Tijmen van der Kemp for the course Object Orientation 2016
 * Joep Veldhoven - s4456556
 * Tijmen van der Kemp - s4446887
 */
package Exercise13.FileFinder;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tijmen
 */
public class FileFinderThreads implements Runnable {
    private final File rootDir;
    private String goalFile;
    
    /**
     * Basic constructor, used to pass the root and the goal file.
     * @param root
     * @param goal
     * @throws IOException 
     */
    public FileFinderThreads (String root, String goal) throws IOException {
        rootDir = new File(root);
        if ( ! (rootDir.exists( ) && rootDir.isDirectory( ) ) ) {
            throw new IOException(root + " is not a directory.") ;
        }
        goalFile = goal;
    }

    /**
     * Finds the file in the root. If it encounters another directory,
     * it creates a subthread for that directory that searches it.
     * @throws IOException 
     */
    private void findFile () throws IOException {
        File [ ] files = rootDir.listFiles( ) ;
        if (files != null ) {
            for (File file: files) {
                if (file.getName( ).equals(goalFile) ) {
                    System.out.println("Found at: " + file.getAbsolutePath( ) ) ;
                    break;
                } else if (file.isDirectory( ) ) {
                    FileFinderThreads newFF = new FileFinderThreads(file.toString(), goalFile);
                    Thread newT = new Thread (newFF);
                    newT.start();
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            findFile() ;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
