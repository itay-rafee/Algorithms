package _3_TortoiseAndHare;

public class Node {

    private int data;
    private Node next;

    public Node(int d){
        data = d;
        next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String toString(){
        return "" + data;
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        Node node2 = new Node(10);
        Node node3 = new Node(20);
        Node node4 = new Node(30);

        System.out.println("node1 : " + node1.toString());
        System.out.println("node2 : " + node2.toString());
        System.out.println("node3 : " + node3.toString());
        System.out.println("node4 : " + node4.toString());
    }
}
