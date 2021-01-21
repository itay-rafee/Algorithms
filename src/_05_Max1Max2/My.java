package _05_Max1Max2;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class NodeCir {
    private int num;
    private Stack<Integer> stack;
    public NodeCir(int n){
        num = n;
        stack = new Stack<>();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }
}

public class My {


    public static int[] maxMax(int[] arr){
        int[] ans = new int[2];
        Queue<NodeCir> q = new LinkedList<>();
        int n = arr.length;
        for (int j : arr) {
            q.add(new NodeCir(j));
        }
        while (q.size() > 1){
            NodeCir n1 = q.poll();
            NodeCir n2 = q.poll();
            if (n1.getNum() > n2.getNum()){
                n1.getStack().push(n2.getNum());
                q.add(n1);
            }
            else {
                n2.getStack().push(n1.getNum());
                q.add(n2);
            }
        }
        NodeCir max = q.poll();
        ans[0] = max.getNum();
        ans[1] = Integer.MIN_VALUE;
        Stack<Integer> st = max.getStack();
        while (!st.empty()){
            int x = st.pop();
            if (ans[1] < x) ans[1] = x;
        }
        return ans;
    }

    public static void main(String[] args) {

        int [] a = {2,4,5,7,8,5,3,1,1,3,4,6,89,4,2,222,0};

        System.out.println(Arrays.toString(maxMax(a)));
    }
}
