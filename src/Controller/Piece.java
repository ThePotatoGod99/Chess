package Controller;

import Data.Board;
import Data.Point;

import static Data.Board.*;

/**
 * Created by simon on 06/12/16.
 */
public class Piece{
    
    
    boolean isDead = false;
    public Point position;
    public char type;//tochange
    
    public boolean isTeamWhite;
    
    public boolean selected = false;
    public boolean isPossibleDestination = false;
    
    public Piece(char theType, boolean isTeamWhite){
        type = theType;
        this.isTeamWhite = isTeamWhite;
    }
    
    public static Piece createEmptyAt(Point position){
        Piece piece = new Piece(EMPTY, false);
        piece.setPosition(position);
        return piece;
    }
    
    public static Piece createXAt(Piece piece){
        Piece newPiece = new Piece(piece.type, piece.isTeamWhite);
        newPiece.isPossibleDestination = true;
        newPiece.setPosition(piece.position);
        
        System.out.println(piece.position.x + " : " + piece.position.y);
        return newPiece;
    }
    
    public Point[] getPossibleDirection(Board theBoard){
        Point[] result = new Point[0];
        switch(type){
            case ROOK:
                result = getPossibleRookDirection(theBoard, position);
                break;
            default:
                System.out.println("ERROR " + getType() + " ]");
                result = new Point[0];
                break;
        }
        
        
        return result;
    }
    
    public Point[] getPossibleRookDirection(Board theBoard, Point thePosition){
        Point[] result = new Point[64];
        int i = 0;
        for(int x = thePosition.x + 1; x < theBoard.getWidth() && theBoard.objectAt(new Point(x, thePosition.y)).type == EMPTY; x++){//Direction right
            Piece object = theBoard.objectAt(new Point(x, thePosition.y));
            if(object.type == EMPTY){
                result[i] = new Point(x, thePosition.y);
                i++;
            }
            else if(object.isTeamWhite != this.isTeamWhite){
                result[i] = new Point(x, thePosition.y);
                i++;
                break;
            }
        }
        
        for(int x = thePosition.x - 1; x >= 0 && theBoard.objectAt(new Point(x, thePosition.y)).type == EMPTY; x--){//Direction left
            Piece object = theBoard.objectAt(new Point(x, thePosition.y));
            if(object.type == EMPTY){
                result[i] = new Point(x, thePosition.y);
                i++;
            }
            else if(object.isTeamWhite != this.isTeamWhite){
                result[i] = new Point(x, thePosition.y);
                i++;
                break;
            }
        }
        
        for(int y = thePosition.y + 1; y < theBoard.getHeight() && theBoard.objectAt(new Point(thePosition.x, y)).type == EMPTY; y++){//Direction down
            Piece object = theBoard.objectAt(new Point(thePosition.x, y));
            if(object.type == EMPTY){
                result[i] = new Point(thePosition.x, y);
                i++;
            }
            else if(object.isTeamWhite != this.isTeamWhite){
                result[i] = new Point(thePosition.x, y);
                i++;
                break;
            }
        }
        
        for(int y = thePosition.y - 1; y >= 0 && theBoard.objectAt(new Point(thePosition.x, y)).type == EMPTY; y--){//Direction down
    
            Piece object = theBoard.objectAt(new Point(thePosition.x, y));
            if(object.type == EMPTY){
                result[i] = new Point(thePosition.x, y);
                
                i++;
            }
            else if(object.isTeamWhite != this.isTeamWhite){
                result[i] = new Point(thePosition.x, y);
                i++;
                break;
            }
        }
        
        
        Point[] result1 = new Point[i];
        for(int j = 0; j < i; j++){
            result1[j] = result[j];
        }
        
        return result1;
    }
    
    public void setType(char type){
        this.type = type;
    }
    
    public char getType(){
        if(selected){
            return SELECTED;
        }
        else if(isPossibleDestination){
            return POSSIBLE_DIRECTION;
        }
        else{
            return type;
        }
    }
    
    public String getStringType(){
        return Character.toString(getType());
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
