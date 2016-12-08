package View;

import Controller.Piece;
import Data.Board;
import Data.Point;

import javax.swing.*;

/**
 * Created by simon on 06/12/16.
 */
public class GameView{
    public GameView(){
        
    }
    
    //public boolean showPossibleDirections;
    
    public void printBoard(Board board){
    }
    
    public void printSelectedPiece(Board board){
    }
    
//    public void showPossibleDirectionForPiece(Board board, Piece piece){
  //  }
    
    //public void hidePossibleDirections(Board board){
    //}
    
    
    public void updateScreen(Board board){
        clearScreen();
        printBoard(board);
    }
    
    public void clearScreen(){
    }
}
