/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise02;


import java.util.ArrayList;
/**
 * One chessboard with cells
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Board {
    
    private final int height, width;
    private int [][] board;
    
    public Board (int height, int width) {
        this.height = height;
        this.width = width;
        board = new int [height][width];
    }
    
    public int getHeight () {
        return height;
    }
    
    public int getWidth () {
        return width;
    }
    
    public int getCell (Position position) {
        return board[position.y][position.x];
    }
    
    public void setCell (Position position, int cellValue) {
        board[position.y][position.x] = cellValue;
    }
    
    public boolean tryCell (Position position, int cellValue) {
        if (getCell(position) == 0) {
            setCell(position, cellValue);
            return true;
        }
        else {
            return false;
        }
    }
    
    public int calcDistance (Position position) {
        int dx = Math.min(position.x, width - 1 - position.x);
        int dy = Math.min(position.y, height - 1 - position.y);
        return dx + dy;
    }
    
    public void printBoard () {
        for (int[] row : board) {
            String rowString = "";
            for (int cell : row) {
                if (cell < 10)
                    rowString += " "; // making sure spacing is correct
                rowString += cell + " ";
            }
            System.out.println(rowString);
        }
    }
    
    
    
    public boolean isLegalPosition (Position p) {
        return (p.y >= 0 && p.y < height && p.x >= 0 && p.x < width);
    }
  
}
