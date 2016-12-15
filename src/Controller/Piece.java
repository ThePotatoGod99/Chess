package Controller;

import Data.Board;
import Data.Point;

import static Data.Board.*;

/**
 * Created by simon on 06/12/16.
 */
public class Piece{
    
    
    public Point position;
    public int type;//tochange
    public boolean isTeamWhite;
    public boolean selected = false;
    public boolean isPossibleDestination = false;
    boolean isDead = false;
    
    public Piece(int theType, boolean isTeamWhite){
        type = theType;
        this.isTeamWhite = isTeamWhite;
    }
    
    public Piece(){
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
        return newPiece;
    }
    
    public Point[] getPossibleDirection(Board theBoard){
        Point[] result = new Point[0];
        switch(type){
            case ROOK:
                result = getPossibleRookDirection(theBoard);
                break;
            case KNIGHT:
                result = getPossibleKnightDirection(theBoard);
                break;
            case BISHOP:
                result = getPossibleBishopDirection(theBoard);
                break;
            default:
                System.out.println("ERROR " + getType() + " ]");
                result = new Point[0];
                break;
        }
        
        
        return result;
    }
    
    public Point[] getPossibleRookDirection(Board theBoard){//Point thePosition){
        Point[] result = new Point[64];
        int i = 0;
        for(int x = position.x + 1; x < theBoard.getWidth(); x++){//Direction right
            Piece object = theBoard.objectAt(new Point(x, position.y));
            if(object.type == EMPTY){
                result[i] = new Point(x, position.y);
                i++;
            }
            else{
                if(object.isTeamWhite != this.isTeamWhite){
                    result[i] = new Point(x, position.y);
                    i++;
                }
                break;
            }
        }
        
        for(int x = position.x - 1; x >= 0; x--){//Direction left
            Piece object = theBoard.objectAt(new Point(x, position.y));
            if(object.type == EMPTY){
                result[i] = new Point(x, position.y);
                i++;
            }
            else{
                if(object.isTeamWhite != this.isTeamWhite){
                    result[i] = new Point(x, position.y);
                    i++;
                }
                break;
            }
        }
        
        
        for(int y = position.y + 1; y < theBoard.getHeight(); y++){//Direction down
            Piece object = theBoard.objectAt(new Point(position.x, y));
            if(object.type == EMPTY){
                result[i] = new Point(position.x, y);
                i++;
            }
            else{
                if(object.isTeamWhite != this.isTeamWhite){
                    result[i] = new Point(position.x, y);
                    i++;
                    
                }
                break;
            }
        }
        
        for(int y = position.y - 1; y >= 0; y--){//Direction down
            
            Piece object = theBoard.objectAt(new Point(position.x, y));
            if(object.type == EMPTY){
                result[i] = new Point(position.x, y);
                
                i++;
            }
            else{
                if(object.isTeamWhite != this.isTeamWhite){
                    result[i] = new Point(position.x, y);
                    i++;
                }
                break;
            }
        }
        
        
        Point[] result1 = new Point[i];
        for(int j = 0; j < i; j++){
            result1[j] = result[j];
        }
        
        return result1;
    }
    
    public Point[] getPossibleKnightDirection(Board theBoard){
        Point[] result = new Point[64];
        int i = 0;
        
        int x = 2;
        int y = 1;
        
        for(int j = 0; j < 8; j++){
            
            Point point = new Point(x + position.x, y + position.y);
            if(point.isInRect(theBoard.getWidth(), theBoard.getHeight())){
                
                
                Piece object = theBoard.objectAt(point);
                if(object.type == EMPTY || object.isTeamWhite != this.isTeamWhite){
                    result[i] = point;
                    i++;
                }
            }
            if(y <= 0){
                x += (x < 0) ? 1 : -1;
                y--;
                
            }
            y *= -1;
            if(x == 0){
                y = 1;
                x = -2;
            }
            
            
        }
        
        Point[] result1 = new Point[i];
        for(int j = 0; j < i; j++){
            result1[j] = result[j];
        }
        
        return result1;
        
    }
    
    public Point[] getPossibleBishopDirection(Board theBoard){
        Point[] result = new Point[64];
        
        int i = 0;
        
        
        Point point = new Point(1, 1);
        
        int limitsReached = 0; //Stop when reaches 4 limits (end of board or pieces)
        Piece object;
        
        int nbToAddToX = 1;
        int nbToAddToY = 1;
        boolean checkNextDirection = false;
        Point absolutePoint;
        while(limitsReached < 4){
            absolutePoint = point.addPoint(position);
            if(absolutePoint.isInRect(theBoard.getWidth(), theBoard.getHeight())){
                object = theBoard.objectAt(absolutePoint);
    
                
                if(object.type == EMPTY){
                    result[i] = absolutePoint;
                    i++;
                }
                else{
                    if(object.isTeamWhite != this.isTeamWhite){
                        result[i] = absolutePoint;
                        i++;
                    }
                    checkNextDirection = true;
                    
                }
            }
            else{
                checkNextDirection = true;
            }
            if(checkNextDirection){
                checkNextDirection = false;
                limitsReached++;
                nbToAddToX *= -1;
                if(nbToAddToX < 0){
                    nbToAddToY *= -1;
                }
                point.x = 0;
                point.y = 0;
            }
            point.x += nbToAddToX;
            point.y += nbToAddToY;
        }
        
        
        Point[] result1 = new Point[i];
        for(int j = 0; j < i; j++){
            result1[j] = result[j];
        }
        
        
        return result1;
    }
    
    public int getType(){
        if(selected){
            return SELECTED;
        }
        else{
            return type;
        }
    }
    
    public void setType(int type){
        this.type = type;
    }
    
    public String getStringType(){
        char character = (char) getType();
        switch(getType()){
            case SELECTED:
                character = 'O';
                break;
            case EMPTY:
                character = ' ';
                break;
            default:
                character += '0';
                break;
            
            
        }
        return Character.toString(character);
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
            case KNIGHT:
                result = "KNIGHT";
                break;
            case BISHOP:
                result = "BISHOP";
                break;
            
            default:
                result = "EMPTY ERROR";
                break;
            
        }
        return result;
    }
}
