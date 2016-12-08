package Controller;

import Data.Board;
import Data.Point;
import View.CommandLineView;
import View.GameView;

/**
 * Created by simon on 08/12/16.
 */
public class GameController{
    private Board board;
    private GameView gameView;
    
    public GameController(Board board){
        this.board = board;
    }
    public void initCommandLineView(){
        gameView = new CommandLineView();
    }
    public boolean movePiece(Piece piece, Point point){
        return board.movePiece(piece, point);
    }
    public boolean moveSelectedPiece(Point point){
        return movePiece(board.getSelectedPiece(), point);
    }
    public boolean selectPiece(Point point){
        gameView.clearScreen();
        Piece thePiece = board.objectAt(point);
        board.setSelectedPiece(board.objectAt(point));
        return true; //TO CHANGE
    }
    public void updateBoard(){
        gameView.updateScreen(board);
    }
    public void printSelectedPiece(){
        gameView.printSelectedPiece(board);
    }
    
    public void showBoard(){
        
        gameView.printBoard(board);
    }
    
    public Board getBoard(){
        return board;
    }
}
