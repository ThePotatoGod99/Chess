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
    
    public static GameController CommandLineController(Board board){
        GameController gameController = new GameController(board);
        gameController.gameView = new CommandLineView();
        return gameController;
    }
    
    public boolean selectPiece(Point point){
        boolean shouldShowDirections = board.showPossibleDirections;
        board.hidePossibleDirections();
        gameView.clearScreen();
        Piece thePiece = board.objectAt(point);
        board.setSelectedPiece(board.objectAt(point));
        if(shouldShowDirections){
            board.showPossibleDirectionForPiece(board.getSelectedPiece());
        }
        return true; //TO CHANGE
    }
    public void updateBoard(){
        gameView.updateScreen(board);
    }
    public void printSelectedPiece(){
        gameView.printSelectedPiece(board);
    }
    
    public void printBoard(){
        gameView.printBoard(board);
    }
    
    public Board getBoard(){
        return board;
    }
}
