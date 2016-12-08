package Data;

import Controller.Piece;

import java.awt.*;

/**
 * Created by simon on 06/12/16.
 */
public class Board{
    public static final char EMPTY = ' ';//change to char
    public static final char ROOK = '2';
    public static final char SELECTED = 'O';
    public static final char POSSIBLE_DIRECTION = 'X';
    
    private int width = 8;
    private int height = 8;
    
    private Piece[][] data = new Piece[width][height];
    private Piece selectedPiece;
    
    public boolean showPossibleDirections = false;
    
    public Board(){
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                this.addToBoard(Piece.createEmptyAt(new Point(i, j)));
            }
        }
    }
    
    
    public void addToBoard(Piece thePiece){
        data[thePiece.position.x][thePiece.position.y] = thePiece;
    }
    
    
    public void movePiece(Piece piece, Point point){
        addToBoard(Piece.createXAt(piece.position));
        piece.setPosition(point);
        addToBoard(selectedPiece);
    }
    
    public boolean moveSelectedPiece(Point point){// Returns false if couldn't move piece
        boolean result = false;
        if(objectAt(point).type == EMPTY || objectAt(point).type == POSSIBLE_DIRECTION){
            movePiece(selectedPiece, point);
            result = true;
        }
        return result;
    }
    
    public static Board createBoardFromTypeMatrice(char[][] theData){
        Board board = new Board();
        for(int y = theData.length - 1; y >= 0; y--){
            for(int x = 0; x < theData[y].length; x++){
                Piece piece = new Piece(theData[x][y]);
                piece.setPosition(new Point(x, y));
                board.addToBoard(piece);
            }
        }
        return board;
    }
    
    
    
    public void showPossibleDirectionForPiece(Piece piece){
        showPossibleDirections = true;
        
        hidePossibleDirections();
        Point[] result = piece.getPossibleDirection(this);
        for(Point point : result){//To delete
            addToBoard(Piece.createXAt(new Point(point.x, point.y)));
        }
    }
    
    public void hidePossibleDirections(){
        //  showPossibleDirections = false;
        for(int i = 0; i < getData().length; i++){
            for(int j = 0; j < getData()[i].length; j++){
                if(getData()[i][j].type == 'X'){
                    addToBoard(Piece.createEmptyAt(new Point(i, j)));
                }
            }
        }
    }
    
    //Getters-Setters
    
    public Piece objectAt(Point index){
        return data[index.x][index.y];
    }
    
    public Piece getSelectedPiece(){
        return selectedPiece;
    }
    
    public void setSelectedPiece(Piece thePiece){
        if(selectedPiece != null){
            selectedPiece.selected = false;
        }
        selectedPiece = thePiece;
        thePiece.selected = true;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public void setWidth(int newWidth){
        width = newWidth;
    }
    
    public void setHeight(int newHeight){
        height = newHeight;
    }
    
    public void setData(Piece[][] newData){
        data = newData;
    }
    
    public Piece[][] getData(){
        return data;
    }
     
}
