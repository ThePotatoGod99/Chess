package Data;

import Controller.Piece;

import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by simon on 06/12/16.
 */
public class Board{
    public static final int EMPTY = -1;//change to char
    public static final int PAWN = 1;
    public static final int ROOK = 2;
    public static final int KNIGHT = 3;
    public static final int BISHOP = 4;
    public static final int QUEEN = 5;
    public static final int KING = 6;
    
    private static final int width = 8;
    private static final int height = 8;
    
    private final Piece[][] data = new Piece[width][height];
    private Point selectedPiece;
    
    public Board(){
        selectedPiece = null;
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
        if(selectedPiece != null){
            showPossibleDirectionForSelectedPiece();
        }
        
    }
    
    public static Board createBoardFromTypeMatrice(int[][] theData){
        Board board = new Board();
        for(int y = theData.length - 1; y >= 0; y--){
            for(int x = 0; x < theData[y].length; x++){
                boolean isTeamWhite = false;
                if(y < width / 2){
                    isTeamWhite = true;
                }
                int type = theData[x][y];
                Piece piece = new Piece(type, isTeamWhite);
                piece.setPosition(new Point(x, y));
                piece.setOriginalPosition(piece.position);
                board.addToBoard(piece);
            }
        }
        return board;
    }
    
    public void showPossibleDirectionForSelectedPiece(){
        Point[] result = getSelectedPiece().getPossibleDirection(this);
        for(Point point : result){//To delete
            objectAt(point).isPossibleDestination = true;
        }
    }
    
    
    //Getters-Setters
    
    public Piece objectAt(Point index){
        return data[index.x][index.y];
    }
    
    public Piece getSelectedPiece(){
        if(selectedPiece != null){
            return objectAt(selectedPiece);
        }
        else{
            return null;
        }
    }
    
    public void setSelectedPiece(Piece thePiece){
        if(selectedPiece != null){
            getSelectedPiece().selected = false;
        }
        selectedPiece = thePiece.position;
        getSelectedPiece().selected = true;
        resetBoard();
    }
    
    public void selectNullPiece(){
        getSelectedPiece().selected = false;
        selectedPiece = null;
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
