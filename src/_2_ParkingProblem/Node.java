package _2_ParkingProblem;

public class Node {
    private char _data;
    private Node _prev, _next;

    public Node(char data, Node prev, Node next){
        _data = data;
        _next = next;
        _prev = prev;
    }

    public String toString(){
        return "" + _data;
    }

    public char getData() {
        return _data;
    }

    public Node getPrev() {
        return _prev;
    }

    public Node getNext() {
        return _next;
    }

    public void setData(char _data) {
        this._data = _data;
    }

    public void setPrev(Node _prev) {
        this._prev = _prev;
    }

    public void setNext(Node _next) {
        this._next = _next;
    }


    public static void main(String[] args) {
        Node node1 = new Node('A', null, null);
        Node node3 = new Node('C', null, null);
        Node node2 = new Node('B', node1, node3);
        System.out.println("node1 : " + node1.toString()); // + " prev - " + node1.getPrev().toString());
        System.out.println("node3 : " + node3.toString()); // + " prev - " + node3.getPrev().toString());
        System.out.println("node2 : " + node2.toString() +
                " prev - " + node2.getPrev().toString() +
                " next - " + node2.getNext().toString());
    }
}
