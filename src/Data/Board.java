package Data;

/**
 * Created by simon on 06/12/16.
 */
public class Board{
    public static final int EMPTY = 0;
    public static final int ROOK = 2;
    
    public int width = 8;
    public int height = 8;
    public int[][] data = new int[width][height];
    public Board(){
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                data[i][j] = EMPTY;
            }
        }
    }
    
    public int objectAt(Point index){
        return data[index.x][index.y];
    }
}
