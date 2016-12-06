import Controller.Piece;
import Data.Board;
import Data.Point;
import View.GameView;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        
        char[] allo7 = {'0', '0', '0', '0', '0', '0', '0', '0'};
        char[] allo6 = {'0', '0', '0', '0', '0', '0', '0', '0'};
        char[] allo5 = {'0', '0', '0', '0', '2', '0', '0', '0'};
        char[] allo4 = {'0', '0', '0', '0', '0', '0', '0', '0'};
        char[] allo3 = {'0', '0', '0', '0', '0', '0', '0', '0'};
        char[] allo2 = {'3', '3', '3', '0', '0', '3', '3', '4'};
        char[] allo1 = {'0', '0', '0', '0', '0', '0', '0', '0'};
        char[] allo0 = {'0', '0', '0', '0', '0', '0', '0', '0'};
        char[][] allo = {allo0, allo1, allo2, allo3, allo4, allo5, allo6, allo7};
        
        
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
        
        
        // board.printBoard();
        Piece piece = new Piece(ROOK);
        piece.setPosition(new Point(2, 3));
        board.addToBoard(piece);
        // System.out.println("ASDFADSF");
        // board.showPossibleDirectionForPiece(piece);
        
        // board.printBoard();
        //for(Point point : result){
        //    System.out.println("\nx: " + point.x + "  y: " + point.y);
        //}
        
        
        boolean continuer = true;
        board.setSelectedPiece(board.objectAt(new Point(2, 3)));
        
        
        while(continuer){
            String fonction = scanInput();
            try{
                switch(fonction.charAt(0)){
                    case 'p':
                        System.out.println(board.showPossibleDirections);
                        clearScreen();
                        board.printBoard();
                        break;
                    case 's':
                        boolean shouldShowDirections = board.showPossibleDirections;
                        board.hidePossibleDirections();
                        clearScreen();
                        int x = fonction.charAt(1) - '0';
                        int y = fonction.charAt(2) - '0';
                        board.setSelectedPiece(board.objectAt(new Point(x, y)));
                        System.out.println(shouldShowDirections);
                        if(shouldShowDirections){
                            board.showPossibleDirectionForPiece(board.getSelectedPiece());
                        }
                        break;
                    case 'd':
                        board.showPossibleDirectionForPiece(board.getSelectedPiece());
                        break;
                    case 'h':
                        board.hidePossibleDirections();
                        break;
                    case 'e':
                        continuer = false;
                    default:
                        break;
                }
            } catch(IndexOutOfBoundsException e){
                System.out.println("Command not found");
            }
        }
    }
    
    public static void clearScreen(){
        for(int i = 0; i < 10; i++){
            System.out.println("\n");
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

