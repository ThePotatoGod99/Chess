package Data;

/**
 * Created by simon on 06/12/16.
 */
public class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean equals(Point point2){
        return (x == point2.x && y == point2.y);
    }
    public boolean isInRect(float width, float height){
        return (x < width && x >= 0 && y >= 0 && y < height);
    }
    /*public boolean isInMatrix(Point[][] matrix){
     return false;
    }*/
}
