package View;

import Controller.GameController;
import Controller.Piece;
import Data.Board;
import Data.Point;

/**
 * Created by simon on 08/12/16.
 */
public class CommandLineView extends GameView{
    public CommandLineView(){
        
    }
    
    
    @Override
    public void printBoard(Board board){
        for(int y = board.getData().length - 1; y >= 0; y--){
            for(int x = 0; x < board.getData()[y].length; x++){
                char result = board.objectAt(new Point(x, y)).getType();
                String patatte = Character.toString(result);
                System.out.print("[" + patatte + "] ");
            }
            System.out.println();
        }
    }
    
    @Override
    public void printSelectedPiece(Board board){
        
        System.out.println("Piece Selected: " + board.getSelectedPiece().getName() + " at " + board.getSelectedPiece().position.x + ":" + board.getSelectedPiece().position.y);
    }
    
    @Override
    public void clearScreen(){
        for(int i = 0; i < 100; i++){
            System.out.println("\n");
        }
    }
}

