package Controller;

import Data.Board;
import Data.Point;

import static Data.Board.EMPTY;
import static Data.Board.ROOK;
import static Data.Board.SELECTED;

/**
 * Created by simon on 06/12/16.
 */
public class Piece{
    
    
    boolean isDead = false;
    public Point position;
    public char type;
    
    public boolean selected = false;
    
    public Piece(char theType){
        type = theType;
    }
   
    public static Piece createEmptyAt(Point position){
        Piece piece = new Piece(EMPTY);
        piece.setPosition(position);
        return piece;
    }
    public static Piece createXAt(Point position){
        Piece piece = new Piece('X');
        piece.setPosition(position);
        return piece;
    }
    public Point[] getPossibleDirection(Board theBoard){
        Point[] result = new Point[0];
        
        switch(type){
            case ROOK:
                result = getPossibleRookDirection(theBoard, position);
                break;
            default:
                System.out.println("ERROR");
                result = new Point[0];
                break;
        }
        
        
        return result;
    }
    
    public Point[] getPossibleRookDirection(Board theBoard, Point thePosition){
        Point[] result = new Point[64];
        int i = 0;
        for(int x = thePosition.x + 1; x < theBoard.getWidth() && theBoard.objectAt(new Point(x, thePosition.y)).type == EMPTY; x++){//Direction right
            if(theBoard.objectAt(new Point(x, thePosition.y)).type == EMPTY){
                result[i] = new Point(x, thePosition.y);
                i++;
            }
        }
        
        for(int x = thePosition.x - 1; x >= 0 && theBoard.objectAt(new Point(x, thePosition.y)).type == EMPTY; x--){//Direction left
            if(theBoard.objectAt(new Point(x, thePosition.y)).type== EMPTY){
                result[i] = new Point(x, thePosition.y);
                i++;
            }
        }
        
        for(int y = thePosition.y + 1; y < theBoard.getHeight() && theBoard.objectAt(new Point(thePosition.x, y)).type == EMPTY; y++){//Direction down
            if(theBoard.objectAt(new Point(thePosition.x, y)).type == EMPTY){
                result[i] = new Point(thePosition.x, y);
                i++;
            }
        }
        
        for(int y = thePosition.y - 1; y >= 0 && theBoard.objectAt(new Point(thePosition.x, y)).type  == EMPTY; y--){//Direction down
            
            //System.out.println(thePosition.x + " : " + y + " board " + theBoard.objectAt(new Point(thePosition.x, y)));
            if(theBoard.objectAt(new Point(thePosition.x, y)).type == EMPTY){
                result[i] = new Point(thePosition.x, y);
                
                i++;
            }
        }
        
        
        
        Point[] result1 = new Point[i];
        for(int j = 0; j < i; j++){
            result1[j] = result[j];
        }
        
        return result1;
    }
    
    public char getType(){
        if(!selected){
            return type;
        }
        else{
            return SELECTED;
        }
    }
    
    
    public void setPosition(Point point){
        position = point;
    }
    public String getName(){
        String result = "";
        switch(type){
            case EMPTY:
                result = "EMPTY";
                break;
            case ROOK:
                result = "ROOK";
                break;
                
            default:
                result = "EMPTY";
                break;
                
        }
        return result;
    }
}
