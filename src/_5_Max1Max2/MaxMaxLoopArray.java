package _5_Max1Max2;

import java.util.Stack;

class NodeA{                               
	int num;
	Stack<Integer> st;
	public NodeA(int num){
		this.num = num;
		st = new Stack<Integer>();
	}
	public String toString(){
		return ""+num;
	}
}

public class MaxMaxLoopArray {
	static int comparisons = 0;
	public static void maxMax2Array(int arr[]){
		int size = arr.length, len = size;
		NodeA a[] = new NodeA[size], t[] = new NodeA[size];

		for (int i=0; i<size; i++){
			a[i] = new NodeA(arr[i]);
		}
		int i=0, j=0;
		while(size>1){
			comparisons++;
			if (a[i].num > a[i+1].num){
				t[j] = a[i];
				t[j].st.push(a[i+1].num);
			}
			else{
				t[j] = a[i+1];
				t[j].st.push(a[i].num);
			}
			i = i + 2;
			j = j + 1;
			comparisons++;
			if (i==len){
				size = len/2;
				len = size;
				a = t;
				t = new NodeA[size];
				i = j = 0;
			}
			else{ 
				comparisons++;
				if (i==len-1){
					size = len/2+1;
					len = size;
					t[j] = a[i];
					a = t;
					t = new NodeA[size];
					i = j = 0;
				}
			}
		}
		int max1 = a[0].num;
		int max2 = a[0].st.pop();
		while (!a[0].st.empty()){
			int x = a[0].st.pop();
			if (x > max2) max2 = x;
		}
		System.out.println("max1 = "+max1 + ", max2 = "+max2);
		System.out.println("comparisons = "+comparisons);
	}

	public static void main(String[] args) {
		//int a[] = {11,3,5,2,7,6,8,9,10};
		int size = 1000000;
		int []a = MyLibrary.randomIntArrayOfDiffNumbers(size);
		//		MyLibrary.printIntegerArray(a);
		long start = System.currentTimeMillis();
		maxMax2Array(a);
		long end = System.currentTimeMillis();
		double diff = ((double)(end - start))/1000.0;
		System.out.println("size = "+size+", time MaxMaxInductionArray: "+diff + " seconds");
	}
}
/**
max1 = 1000000, max2 = 999999
size = 1000000, time MaxMaxInductionArray: 0.93 seconds

 */