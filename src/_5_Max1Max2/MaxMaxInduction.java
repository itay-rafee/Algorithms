package _5_Max1Max2;

import java.util.Arrays;
import java.util.Stack;

class Node {
    private int num;
    private Stack<Integer> st;
    private Node next, prev;
    private int size;

    public Node(int num, Node n, Node p) {
        this.num = num;
        st = new Stack<>();
        next = n;
        prev = p;
    }

    public Node(int num) {
        this.num = num;
        st = new Stack<>();
        next = null;
        prev = null;
    }

    public String toString() {
        return "" + num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Stack<Integer> getSt() {
        return st;
    }

    public void setSt(Stack<Integer> st) {
        this.st = st;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

public class MaxMaxInduction {

    public static int maxMax2LinkedList(int[] arr) {//Circle Linked List
        int comparisons = 0;
        Node head = new Node(arr[0]);
        Node n = head;
        for (int i = 1; i < arr.length; i++) {
            n.setNext(new Node(arr[i], null, n));
            n = n.getNext();
        }
        head.setPrev(n);
        n.setNext(head);
        // Pair Process
        int size = arr.length;
        Node n1 = head, n2;
        while (size > 1) {
            n2 = n1.getNext();
            comparisons++;
            if (n1.getNum() < n2.getNum()) {
                n2.getSt().push(n1.getNum());
                n1.getPrev().setNext(n2);// remove n1
                n2.setPrev(n1.getPrev());
                n1 = n2.getNext();
            } else {
                n1.getSt().push(n2.getNum());
                n1.setNext(n2.getNext());// remove n2
                n2.getNext().setPrev(n1);
                n1 = n2.getNext();
            }
            size--;
        }
        // last stack
        int max1 = n1.getNum();
        int max2 = n1.getSt().pop();
        //System.out.println("comp = "+comparisons);
        //System.out.println("n1.st.size = " + n1.st.size());
        while (!n1.getSt().isEmpty()) {
            int number = n1.getSt().pop();
            comparisons++;
            if (max2 < number) max2 = number;
        }
        System.out.println("max1 = " + max1 + " ,max2 = " + max2);
        return comparisons;
    }

    public static void main(String[] args) {
        //int a[] = {1,10,8,9,5,20,11,18};
        //int a[] = {1,10,8,9,5,20,11,18,19};
        //int[] a = {6, 10, 8, 7, 3, 2, 9, 5, 1, 4}; //12 comparisons
        int[]a = {6, 7, 8, 5, 1, 4, 2, 3};


        int size = 1000000, loop = 100;
        double diff = 0;
        int comp = 0;
        System.out.println("size = " + size + ";  loop = " + loop);
        for (int i = 1; i <= loop; i++) {
            //int[] a = MyLibrary.randomIntArrayOfDiffNumbers(size);
            //System.out.println(Arrays.toString(a));
            long start = System.currentTimeMillis();
            comp = comp + maxMax2LinkedList(a);
            long end = System.currentTimeMillis();
            diff = diff + ((double) (end - start)) / 1000.0;
        }
        System.out.println("MaxMaxInduction (comp = n + log(n))");
        System.out.printf("time MaxMaxInduction: %7.3f", diff / loop);
        System.out.println(";  number of comparisons: " + comp / loop);
    }
}
/**
 * max1 = 1000000 ,max2 = 999999
 * comp = 1000018
 * size = 1000000, time MaxMaxInduction: 1.37
 */