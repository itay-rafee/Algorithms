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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumOfPaths() {
        return numOfPaths;
    }

    public void setNumOfPaths(int numOfPaths) {
        this.numOfPaths = numOfPaths;
    }
}// class Node

