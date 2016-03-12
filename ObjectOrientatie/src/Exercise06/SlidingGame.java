package Exercise06;

import java.util.Collection;
import java.util.ArrayList;


/**
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.3
 * @date 07-03-2016
 * A template implementation of a sliding game also
 * implementing the Graph interface
 */
public class SlidingGame implements Configuration
{
    public static final int N = 3, SIZE = N * N, HOLE = SIZE;
    /**
     * The board is represented by a 2-dimensional array; the position of the
     * hole is kept in 2 variables holeX and holeY
     */
    private int[][] board;
    private int holeX, holeY;
    private int manhattan;

    /**
     * A constructor that initializes the board with the specified array
     *
     * @param start: a one dimensional array containing the initial board. The
     * elements of start are stored row-wise.
     */
    public SlidingGame(int[] start) {
        board = new int[N][N];

        assert start.length == N * N : "Length of specified board incorrect";

        for (int p = 0; p < start.length; p++) {
            board[p / N][p % N] = start[p];
            if (start[p] == HOLE) {
                holeX = p % N;
                holeY = p / N;
            }
        }
    }

    /**
     * Converts a board into a printable representation. The hole is displayed
     * as a space
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int puzzel = board[row][col];
                buf.append(puzzel == HOLE ? "  " : puzzel + " ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    /**
     * a standard implementation of equals checking whether 2 boards are filled
     * in exactly the same way
     *
     * @return a boolean indicating equality
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        } else {
            SlidingGame other_puzzle = (SlidingGame) o;
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (board[row][col] != other_puzzle.board[row][col]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @Override
    public boolean isSolution() {
        for(int row = 0; row < N; row ++){
            for(int col = 0; col < N; col ++){
                if(board[row][col] != N * row + col + 1)
                    return false;
            }
        }
        return true;
    }

    @Override
    public Collection<Configuration> successors() {
        ArrayList<Configuration> successors = new ArrayList<>();
        
        for (Direction dir : Direction.values()) {
            Configuration possibleSuccessor = successor(dir);
            
            if (possibleSuccessor != null) {
                successors.add(possibleSuccessor);
//                System.out.println("Added successor: " + dir.toString() + "\n" + possibleSuccessor.toString());
            }
        }
        
        return successors;
        
    }
    
    private Configuration successor (Direction dir) {
        
        if (holeX + dir.getDX() < 0 || holeX + dir.getDX() >= N
                || holeY + dir.getDY() < 0 || holeY + dir.getDY() >= N) {
            
            return null;
        }
        
        int manhattanOffset = 0; 
        
        int[] numberArray = new int[N*N];
        for (int row = 0; row < N; row ++){
            for (int col = 0; col < N; col ++){
                // New hole position
                if (row == holeY + dir.getDY() && col == holeX + dir.getDX()){
                    numberArray[N * row + col] = HOLE;
                    manhattanOffset = calculateManhattanOffset(dir, row, col);
                }
                // Previous hole position
                else if (row == holeY && col == holeX) {
                    numberArray[N * row + col] = board[row + dir.getDY()][col + dir.getDX()];
                }
                // Proceed as normal
                else {
                    numberArray[N * row + col] = board[row][col];
                }
            }
        }
        
        SlidingGame returnGame = new SlidingGame(numberArray);
        returnGame.setManhattan(manhattan + manhattanOffset);
        System.out.println(manhattan + manhattanOffset);
        return returnGame;
    }
    
            
    public int calculateManhattanOffset (Direction dir, int row, int col) {
        // This piece is going to get moved, so the manhattan distance
        // will shift by one. Determine which way it shifts.
        switch(dir) {
            case EAST:{
                if (board[row][col] % N >= col)
                    return 1;
                else
                    return -1;
            }
            case WEST:{
                if (board[row][col] % N > col)
                    return -1;
                else
                    return 1;
            }
            case NORTH:{
                if (board[row][col] / N > row)
                    return -1;
                else
                    return 1;
            }
            case SOUTH:{
                if (board[row][col] / N >= row)
                    return 1;
                else
                    return -1;
            }

        }
        return 0;
    }
    
    public void calculateManhattan () {
        manhattan = 0;
        for (int row = 0; row < N; row ++) {
            for (int col = 0; col < N; col ++) {
                int value = board[row][col];
                
                if (value != HOLE) {
                    manhattan += Math.abs(row - value / N);
                    manhattan += Math.abs(col - value % N);
                }
            }
        }
    }
    
    public int getManhattan () {
        return manhattan;
    }
    
    public void setManhattan (int m) {
        manhattan = m;
    }

    @Override
    public int compareTo(Configuration g) {
        return this.manhattan - g.getManhattan();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        for (int row = 0; row < N; row ++) {
            for (int col = 0; col < N; col ++) {
                hash += board[row][col] * 31^(row+col*N);
            }
        }
        return hash;
    }

}
