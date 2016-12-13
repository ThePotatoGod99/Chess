package Data;

import Controller.Piece;

import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by simon on 06/12/16.
 */
public class Board{
    public static final int EMPTY = -1;//change to char
    public static final int ROOK = 2;
    public static final int KNIGHT = 3;
    public static final int SELECTED = 0;
    public static final int POSSIBLE_DIRECTION = -2;
    
    private static final int width = 8;
    private static final int height = 8;
    
    private Piece[][] data = new Piece[width][height];
    private Point selectedPiece;
    
    public Board(){
        
        selectedPiece = new Point(2, 3);
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                this.addToBoard(Piece.createEmptyAt(new Point(i, j)));
            }
        }
    }
    
    
    public void addToBoard(Piece thePiece){
        data[thePiece.position.x][thePiece.position.y] = thePiece;
    }
    
    
    public boolean movePiece(Piece piece, Point point){
        if(objectAt(point).isPossibleDestination){
            Piece emptyPiece = Piece.createEmptyAt(selectedPiece);
            getSelectedPiece().setPosition(point);
            addToBoard(getSelectedPiece());
            selectedPiece = point;
            addToBoard(emptyPiece);
            resetBoard();
            return true;
        }
        return false;
    }
    
    public boolean moveSelectedPiece(Point point){// Returns false if couldn't move piece
        return movePiece(getSelectedPiece(), point);
    }
    
    public void resetBoard(){
        for(Piece[] row : data){
            for(Piece piece : row){
                piece.isPossibleDestination = false;
            }
        }
        showPossibleDirectionForSelectedPiece();
        
    }
    
    public static Board createBoardFromTypeMatrice(int[][] theData){
        Board board = new Board();
        for(int y = theData.length - 1; y >= 0; y--){
            for(int x = 0; x < theData[y].length; x++){
                int type = theData[x][y];
                Piece piece = new Piece(type, false);
                piece.setPosition(new Point(x, y));
                board.addToBoard(piece);
            }
        }
        return board;
    }
    
    public void showPossibleDirectionForSelectedPiece(){
        Point[] result = getSelectedPiece().getPossibleDirection(this);
        for(Point point : result){//To delete
            addToBoard(Piece.createXAt(objectAt(point)));
        }
    }
    
    
    //Getters-Setters
    
    public Piece objectAt(Point index){
        return data[index.x][index.y];
    }
    
    public Piece getSelectedPiece(){
        return objectAt(selectedPiece);
    }
    
    public void setSelectedPiece(Piece thePiece){
        
        if(selectedPiece != null){
            getSelectedPiece().selected = false;
        }
        selectedPiece = thePiece.position;
        getSelectedPiece().selected = true;
        resetBoard();
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    
    public void setData(Piece[][] newData){
        data = newData;
    }
    
    public Piece[][] getData(){
        return data;
    }
    
}
