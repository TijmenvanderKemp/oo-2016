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
            board[p % N][p / N] = start[p];
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
                int puzzel = board[col][row];
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
                    if (board[col][row] != other_puzzle.board[col][row]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @Override
    public boolean isSolution() {
        for(int j = 0; j < N; j++){
            for(int i = 0; i < N; i++){
                if(board[i][j] != N*j + i + 1)
                    return false;
            }
        }
        return true;
    }

    @Override
    public Collection<Configuration> successors() {
        ArrayList<Configuration> successors = new ArrayList<>();
        if(holeY - 1 > 0){
            int[] north = new int[N*N];
            for(int j = 0; j < N; j++){
                for(int i = 0; i < N; i++){
                    if(i == holeX && j == holeY-1){
                        north[N*j+i] = N*N;
                    }
                    else{
                        if(i == holeX && j == holeY)
                            north[N*j+i] = board[i][holeY-1];
                        else
                            north[N*j+i]=board[i][j];
                    }
                }
            }
            Configuration successornorth = new SlidingGame(north);
            successors.add(successornorth);
        }
        if(holeX + 1 < N){
            int[] east = new int[N*N];
            for(int j = 0; j < N; j++){
                for(int i = 0; i < N; i++){
                    if(i == holeX + 1 && j == holeY){
                        east[N*j+i] = N*N;
                    }
                    else{
                        if(i == holeX && j == holeY)
                            east[N*j+i] = board[holeX+1][j];
                        else
                            east[N*j+i]=board[i][j];
                    }
                }
            }
            Configuration successoreast = new SlidingGame(east);
            successors.add(successoreast);
        }
        if(holeY + 1 < N){
            int[] south = new int[N*N];
            for(int j = 0; j < N; j++){
                for(int i = 0; i < N; i++){
                    if(i == holeX && j == holeY+1){
                        south[N*j+i] = N*N;
                    }
                    else{
                        if(i == holeX && j == holeY)
                            south[N*j+i] = board[i][holeY+1];
                        else
                            south[N*j+i]=board[i][j];
                    }
                }
            }
            Configuration successorsouth = new SlidingGame(south);
            successors.add(successorsouth);
        }
        if(holeX - 1 >0){
            int[] west = new int[N*N];
            for(int j = 0; j < N; j++){
                for(int i = 0; i < N; i++){
                    if(i == holeX - 1 && j == holeY){
                        west[N*j+i] = N*N;
                    }
                    else{
                        if(i == holeX && j == holeY)
                            west[N*j+i] = board[holeX - 1][j];
                        else
                            west[N*j+i]=board[i][j];
                    }
                }
            }
            Configuration successorwest = new SlidingGame(west);
            successors.add(successorwest);
        }
        return successors;
        
    }

    @Override
    public int compareTo(Configuration g) {
        throw new UnsupportedOperationException("compareTo : not supported yet.");
    }

}
