package Controller;

import Data.Board;
import Data.Point;

import static Data.Board.ROOK;

/**
 * Created by simon on 06/12/16.
 */
public class Piece{
    
    
    
    boolean isDead = false;
    Point position;
    int type;
    public Piece(int theType){
        type = theType;
    }
    
    public Point[] getPossibleDirection(Board theBoard){
        Point[] result = new Point[64];
        
        switch(type){
            case ROOK:
                result = getPossibleRookDirection(theBoard, position);
                break;
            default:
                break;
        }
        
        
        return result;
    }
    
    public Point[] getPossibleRookDirection(Board theBoard, Point thePosition){
        Point[] result = new Point[64];
        int i = 0;
        System.out.println("ASDFASDF");
        for(int x = thePosition.x + 1; x < theBoard.width && theBoard.objectAt(new Point(x, thePosition.y)) == 0; x++){//Direction right
            if(theBoard.objectAt(new Point(x, thePosition.y)) == 0){
                result[i] = new Point(x, thePosition.y);
                i++;
            }
        }
    
        for(int x = thePosition.x - 1; x >= 0 && theBoard.objectAt(new Point(x, thePosition.y)) == 0; x--){//Direction left
            if(theBoard.objectAt(new Point(x, thePosition.y)) == 0){
                result[i] = new Point(x, thePosition.y);
                i++;
            }
        }
    
        for(int y = thePosition.y + 1; y < theBoard.height && theBoard.objectAt(new Point(thePosition.x, y)) == 0; y++){//Direction down
            if(theBoard.objectAt(new Point(thePosition.x, y)) == 0){
                result[i] = new Point(thePosition.x, y);
                i++;
            }
        }
        
        for(int y = thePosition.y - 1; y >= 0 && theBoard.objectAt(new Point(thePosition.x, y)) == 0; y--){//Direction down
    
            System.out.println(thePosition.x + " : " +  y + " board " + theBoard.objectAt(new Point(thePosition.x, y)));
            if(theBoard.objectAt(new Point(thePosition.x, y)) == 0){
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
    
    
    public void setPosition(Point point){
        position = point;
    }
}
