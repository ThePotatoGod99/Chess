package View;

import Controller.GameController;
import Controller.Piece;
import Data.Board;
import Data.Point;

import static Data.Board.EMPTY;

/**
 * Created by simon on 08/12/16.
 */
public class CommandLineView extends GameView{
    public CommandLineView(){
    }
    
    @Override
    public void printBoard(Board board){
        Piece[][] data = board.getData();
        for(int y = data.length - 1; y >= 0; y--){
            for(int x = 0; x < data[y].length; x++){
                Piece object = board.objectAt(new Point(x, y));
                String result = object.getStringType();
                if(object.isPossibleDestination){
                    if(object.type == EMPTY){
                        result = ".";
                    }
                    System.out.print(" {" + result + "} ");
                }
                else if(object.selected){
                    System.out.print(" (" + result + ") ");
                }
                else if(object.type == EMPTY){
                    System.out.print("  -  ");
                }
                else if(object.isTeamWhite){
                    System.out.print(" |" + result + "| ");
                }
                else{
                    System.out.print(" [" + result + "] ");
                }
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
        
        for(int i = 0; i < 100; i++)
            System.out.println("\n");
    }
}

