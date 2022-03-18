package src;

public class Point implements Place {
    private int x, y;

    public int distance(Place other) {
        Point temp = (Point)(other);
        return (int)(Math.sqrt((Math.pow((temp.x - this.x), 2) + Math.pow(temp.y - this.y, 2))));
    }
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

}
