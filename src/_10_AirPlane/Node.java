package _10_AirPlane;

public class Node {
    int x, y, price, numOfPaths;//, price2;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
        this.price = 0;
        this.numOfPaths = 0;
    }
    public String toString(){
        return "("+x+","+y+") ";
    }
}// class Node

