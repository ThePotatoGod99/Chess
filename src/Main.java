import Controller.GameController;
import Controller.Piece;
import Data.Board;
import Data.Point;
import View.GameView;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Data.Board.*;

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
        
        int[] allo7 = {ROOK, PAWN, EMPTY, EMPTY, EMPTY, EMPTY, PAWN, ROOK};
        int[] allo6 = {KNIGHT, PAWN, EMPTY, EMPTY, EMPTY, EMPTY, PAWN, KNIGHT};
        int[] allo5 = {BISHOP, PAWN, EMPTY, EMPTY, EMPTY, EMPTY, PAWN, BISHOP};
        int[] allo4 = {QUEEN, PAWN, EMPTY, EMPTY, EMPTY, EMPTY, PAWN, QUEEN};
        int[] allo3 = {KING, PAWN, EMPTY, EMPTY, EMPTY, EMPTY, PAWN, KING};
        int[] allo2 = {BISHOP, PAWN, EMPTY, EMPTY, EMPTY, EMPTY, PAWN, BISHOP};
        int[] allo1 = {KNIGHT, PAWN, EMPTY, EMPTY, EMPTY, EMPTY, PAWN, KNIGHT};
        int[] allo0 = {ROOK, PAWN, EMPTY, EMPTY, EMPTY, EMPTY, PAWN, ROOK};
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
        boolean continuer = true;
        
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
                    case 'l':
                        System.out.println("1: Pawn\n2: Rook\n 3: Knight\n 4: Bishop\n 5: Queen\n 6: King\n\nWhite pieces are written like this: |x|\nBlack pieces are written like this: [x]\n");
                        break;
                    case 'h':
                        System.out.println("'p' to show the board.\n'e' to exit\n's' to select piece (type \"s21\" to select the piece at the position 2-1)\n'm' to move the piece (type \"m23\" to move to 2-3)\n'l' show the legend\n");
                                
                        break;
                    default:
                        System.out.println("Type 'h' for help");
                        break;
                }
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Command not found. Write 'h' for help");
            }
        }
    }
    
    
    public static String scanInput(){
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            return bufferRead.readLine();
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}

