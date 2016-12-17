package Controller;

import Data.Board;
import Data.Point;
import View.CommandLineView;
import View.GameView;
import sun.invoke.empty.Empty;

import java.util.EnumMap;

import static Data.Board.EMPTY;

/**
 * Created by simon on 08/12/16.
 */
public class GameController{
    private Board board;
    private GameView gameView;
    
    private boolean isWhiteTurn = true;
    
    public GameController(Board board){
        this.board = board;
    }
    
    public void initCommandLineView(){
        gameView = new CommandLineView();
    }
    
    public boolean movePiece(Piece piece, Point point){
        boolean result = board.movePiece(piece, point);
        if(result){
            isWhiteTurn ^= true;
            selectNullPiece();
        }
        return result;
    }
    
    public boolean moveSelectedPiece(Point point){
        return movePiece(board.getSelectedPiece(), point);
    }
    
    public boolean selectPiece(Point point){
        Piece object = board.objectAt(point);
        if(object.isTeamWhite == isWhiteTurn && object.type != EMPTY){
            board.setSelectedPiece(object);
            return true;
        }
        
        System.out.println("Please select one of your pieces");
        return false;
    }
    
    public void selectNullPiece(){
        board.selectNullPiece();
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
