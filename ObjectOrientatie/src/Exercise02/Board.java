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
            System.out.println(rowString + '\n');
        }
    }
    
    public move (Position cur_pos, Move move){
        ArrayList pos_moves = new ArrayList();
        int cur_x = cur_pos.x;
        int cur_y = cur_pos.y;
        switch(move){
            case NNE:
                Position NNE_pos = new Position(cur_y + 1, cur_x - 2);
                if(is_legal(NNE_pos)){
                    pos_moves.add(NNE_pos);
                }
            case EEN:
                Position EEN_pos = new Position(cur_y + 2, cur_x - 1);
                if(is_legal(EEN_pos)){
                    pos_moves.add(EEN_pos);
                }
            case EES:
                Position EES_pos = new Position(cur_y + 2, cur_x + 1);
                if(is_legal(EES_pos)){
                    pos_moves.add(EES_pos);
                }
            case SSE:
                Position SSE_pos = new Position(cur_y + 1, cur_x + 2);
                if(is_legal(SSE_pos)){
                    pos_moves.add(SSE_pos);
                }
            case SSW:
                Position SSW_pos = new Position(cur_y - 1, cur_x + 2);
                if(is_legal(SSW_pos)){
                    pos_moves.add(SSW_pos);
                }
            case WWS:
                Position WWS_pos = new Position(cur_y - 2, cur_x + 1);
                if(is_legal(WWS_pos)){
                    pos_moves.add(WWS_pos);
                }
            case WWN:
                Position WWN_pos = new Position(cur_y - 2, cur_x - 1);
                if(is_legal(WWN_pos)){
                    pos_moves.add(WWN_pos);
                }
            case NNW:
                Position NNW_pos = new Position(cur_y - 1, cur_x - 2);
                if(is_legal(NNW_pos)){
                    pos_moves.add(NNW_pos);
                }
            sort(pos_moves);
        }
    }
}
