/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Exercise02 {
    
    public static void main (String[] args) {
        Exercise02 exercise02 = new Exercise02 ();
    }
    
    public Exercise02 () {
        Board board = new Board(4, 4);
        board.printBoard();
        
        Position currentPosition = new Position (0, 0);
        
        while(true) {
            ArrayList nextMoves = generateNextSteps (board, currentPosition);
        }
    }
    
    public ArrayList<Position> generateNextSteps (Board b, Position currentPosition){
        ArrayList<Position> possibleMoves = new ArrayList();
        for (Move m : Move.values()) {
            Position newPosition = new Position (currentPosition.y + m.y, currentPosition.x + m.x);
            if (b.isLegalPosition(newPosition) && b.tryCell(newPosition, 0)) // Check to see if the move is in the board and free
                possibleMoves.add(newPosition);
        }
        return possibleMoves;
    }
}
