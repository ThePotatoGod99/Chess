import Controller.Piece;
import Data.Board;
import Data.Point;
import View.GameView;

import javax.swing.*;

import static Data.Board.ROOK;

/**
 * Created by simon on 06/12/16.
 */
public class Main{
    public static void main(String[] args){
      /*  JFrame frame = new JFrame("Chess");
        GameView view = new GameView();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        
        frame.add(view);
        frame.setVisible(true);*/
        
        Board board = new Board();
    
        int[] allo7 = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] allo6 = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] allo5 = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] allo4 = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] allo3 = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] allo2 = {3, 3, 3, 0, 0, 3, 3, 4};
        int[] allo1 = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] allo0 = {0, 0, 0, 0, 0, 0, 0, 0};
        int[][] allo = {allo0, allo1,allo2,allo3,allo4,allo5,allo6,allo7};
        
        
        
        board.data = allo;
        for(int y = 0; y < allo.length; y++){
            for(int x = 0; x < allo[y].length; x++){
                System.out.print(board.objectAt(new Point(x, y)) + " : ");
            }
            System.out.println();
        }
        
        
        
       //
        Piece piece = new Piece(ROOK);
        piece.setPosition(new Point(5, 5));
        Point[] result  = piece.getPossibleDirection(board);
        
        for(Point point : result){
            System.out.println("\nx: " + point.x + "  y: " + point.y);
        }
    }
}

