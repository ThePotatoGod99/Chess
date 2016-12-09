import Controller.GameController;
import Controller.Piece;
import Data.Board;
import Data.Point;
import View.GameView;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Data.Board.EMPTY;
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
        
        int[] allo7 = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        int[] allo6 = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        int[] allo5 = {EMPTY, EMPTY, EMPTY, EMPTY, ROOK, EMPTY, EMPTY, EMPTY};
        int[] allo4 = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        int[] allo3 = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        int[] allo2 = {3, 3, 3, EMPTY, EMPTY, 3, 3, 4};
        int[] allo1 = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        int[] allo0 = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        int[][] allo = {allo0, allo1, allo2, allo3, allo4, allo5, allo6, allo7};
        
        
        board = Board.createBoardFromTypeMatrice(allo);
        
        /*
        [0] [0] [4] [0] [0] [0] [0] [0]
        [0] [0] [3] [0] [0] [0] [0] [0]
        [0] [0] [3] [0] [0] [0] [0] [0]
        [0] [0] [0] [0] [0] [0] [0] [0]
        [0] [0] [X] [0] [0] [0] [0] [0]
        [0] [0] [3] [0] [0] [0] [0] [0]
        [0] [0] [3] [0] [0] [0] [0] [0]
        [0] [0] [3] [0] [0] [0] [0] [0]
         */
        Piece piece = new Piece(ROOK, true);
        piece.setPosition(new Point(2, 3));
        board.addToBoard(piece);
        boolean continuer = true;
        board.setSelectedPiece(board.objectAt(new Point(2, 3)));
    
        GameController controller = new GameController(board);
        controller.initCommandLineView();
        
        while(continuer){
            String fonction = scanInput();
            try{
                switch(fonction.charAt(0)){
                    case 'p':
                        
                        controller.showBoard();
                        
                        break;
                    case 's':
                        int x = fonction.charAt(1) - '0';
                        int y = fonction.charAt(2) - '0';
                        controller.selectPiece(new Point(x, y));
                        break;
                    case 'e':
                        continuer = false;
                    case 'm':
                        x = fonction.charAt(1) - '0';
                        y = fonction.charAt(2) - '0';
                        if(!controller.moveSelectedPiece(new Point(x, y))){
                            System.out.println("Select Valid Destination");
                        }
                        break;
                    default:
                        break;
                }
            } catch(IndexOutOfBoundsException e){
                System.out.println("Command not found");
            }
        }
    }
    
    
    public static String scanInput(){
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            return bufferRead.readLine();
            
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}

