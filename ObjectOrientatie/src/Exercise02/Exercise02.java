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
        Scanner scanner = new Scanner(System.in);
        Board board = new Board(6, 6);
        
        Position currentPosition = new Position (0, 0);
        int moveCounter = 1;
        System.out.println("Do you want a full loop (y/N)");
        String userInput = scanner.nextLine();
        boolean fullTour = (userInput == "y");
        recursiveSolve (board, currentPosition, moveCounter, fullTour, scanner);
        
        board.printBoard();
    }
    
    public boolean recursiveSolve (Board board, Position currentPosition, int moveCounter, boolean fullTour, Scanner scanner) {
        
        board.tryCell(currentPosition, moveCounter);
        
        if (!fullTour && moveCounter >= board.getHeight() * board.getWidth()) {
            return true; // All squares are filled
        }
        
        if (fullTour && moveCounter >= board.getHeight() * board.getWidth()) {
            for (Move move : Move.values()) {
                Position newPos = new Position(currentPosition.y + move.y, currentPosition.x + move.x);
                if (board.isLegalPosition(newPos) && board.getCell(newPos) == 1)
                    return true; // All squares are filled and we are back at the start
            }
            board.setCell(currentPosition, 0);
            return false; // All squares are filled but we aren't back at the start
        }
        
        ArrayList<Position> nextMoves = generateNextSteps (board, currentPosition);
        if (nextMoves.isEmpty()) {
            board.setCell(currentPosition, 0);
            return false; // No next moves, dead end
        }
        sortNextMoves (board, nextMoves);
        
        for (Position move : nextMoves) {
            if (recursiveSolve (board, move, moveCounter + 1, fullTour, scanner)) {
                return true; // Found a solution in one of the following moves
            }
        }
        
        board.setCell(currentPosition, 0);
        
        return false; // All moves are a dead end
    }
    
    public ArrayList<Position> generateNextSteps (Board board, Position currentPosition){
        ArrayList<Position> possibleMoves = new ArrayList();
        for (Move m : Move.values()) {
            Position newPosition = new Position (currentPosition.y + m.y, currentPosition.x + m.x);
            if (board.isLegalPosition(newPosition) && board.tryCell(newPosition, 0)) // Check to see if the move is in the board and free
                possibleMoves.add(newPosition);
        }
        return possibleMoves;
    }
    
    public void sortNextMoves (Board board, ArrayList<Position> nextMoves) {
        int length = nextMoves.size();
        // Standard bubble sort
        for (int i = length - 1; i >=0 ; i --) {
            for (int j = 0; j < i; j ++) {
                if (board.calcDistance(nextMoves.get(j)) > board.calcDistance(nextMoves.get(j+1))){
                    swapPositions (nextMoves, j, j+1);
                }
            }
        }
    }
    
    public void swapPositions (ArrayList<Position> nextMoves, int a, int b) {
        Position temp = nextMoves.get(a);
        nextMoves.set(a, nextMoves.get(b));
        nextMoves.set(b, temp);
    }
}
