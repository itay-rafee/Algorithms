package _05_Max1Max2;
/**
   Three algorithms search for 2 largest elements of an array. 
   Each function returns the number of comparisons
   A={arr[0], arr[1], . . . ,arr[arr.length]}
   max1 = maximum{A}
   max2 = maximum{A\max1}
   Remark: the start values of max1, max2 must be different.
   Assumptions: 
   				1)elements of the array are different
   				2) array length > 2
 **/
public class MaxMax {
	/**
	 * The function twoMaxGreatThanMax1 
	 * searches two largest elements of the an array
	 * the first check is: a[i]>max1 
	 * @param arr - the array
	 * @return variable count the number of comparisons
	 */
	public static int twoMaxGreatThanMax1(int arr[]){//2n comparisons
		// initialization
		int max1 = arr[0];
		int max2 = arr[1];
		if (max1 < max2){
			max1 = arr[1];
			max2 = arr[0];
		}
		// the main loop
		int comparisons = arr.length - 2;
		for (int i=2; i<arr.length; i++){
			// the first comparison
			if(arr[i] > max1){
				max2=max1;
				max1=arr[i];
			}
			else{
				comparisons++;
				if(arr[i]>max2) max2=arr[i];
			}
		}
		// the result:
		//System.out.println("max1 = "+max1+", max2 = "+max2);
		return comparisons;
	}
	/**
	 * The function twoMaxGreatThanMax2 
	 * searches two largest elements of the an array
	 * the first check is: a[i]>max2 
	 * @param arr - the array
	 * @return variable count the number of comparisons
	 */
	public static int twoMaxGreatThanMax2(int arr[]){//n comparisons
		// initialization
		int max1 = arr[0];
		int max2 = arr[1];
		if (max1 < max2){
			max1 = arr[1];
			max2 = arr[0];
		}
		int comparisons = arr.length - 2;
		// the main loop
		for (int i=2; i<arr.length; i++){
			// the first comparison
			if(arr[i] > max2){ 
				comparisons++;
				if (arr[i] < max1) max2 = arr[i];
				else{
					max2 = max1;
					max1 = arr[i];
				}
			}
		}
		// print the result:
		//System.out.println("max1 = "+max1+", max2 = "+max2);
		return comparisons;
	}
	public static int twoMaxPairs1(int arr[]){//(3/2)*n comparisons
		// initialization
		int max1 = arr[0];
		int max2 = arr[1];
		if (max1 < max2){
			max1 = arr[1];
			max2 = arr[0];
		}
		int comparisons = 0;//arr.length/2 - 1;
		// the main loop
		for (int i=2; i<arr.length-1; i = i + 2){
			comparisons++;
			if (arr[i] > arr[i+1]){
				comparisons++;
				if (arr[i] > max1){
					/// max2 = max(max1, arr[i+1])
					comparisons++;
					if (max1 > arr[i+1]){
						max2 = max1;
					}
					else{
						max2 = arr[i+1];
					}
					max1 = arr[i];
				}
				else{
					comparisons++;
					if (arr[i] > max2) max2 = arr[i];
				}
			}
			else{
				comparisons++;
				if (arr[i+1] > max1){
					/// max2 = max(max1, arr[i])
					comparisons++;
					if (max1 > arr[i]){
						max2 = max1;
					}
					else{
						max2 = arr[i];
					}
					max1 = arr[i+1];
				}
				else{
					comparisons++;
					if (arr[i+1] > max2) max2 = arr[i+1];
				}
			}
		}
		comparisons++;
		if (arr.length%2 != 0){
			comparisons++;
			if (arr[arr.length-1] > max1){
				max2 = max1;
				max1 = arr[arr.length-1];
			}
			else {
				comparisons++;
				if (arr[arr.length-1] > max2) max2 = arr[arr.length]-1;
			}
		}
		// print the result:
		System.out.println("max1 = "+max1+", max2 = "+max2);
		return comparisons;
	}
	public static int twoMaxPairs2(int arr[]){//n comparisons
		// initialization
		int max1 = arr[0];
		int max2 = arr[1];
		if (max1 < max2){
			max1 = arr[1];
			max2 = arr[0];
		}
		int comparisons = 0;//arr.length/2 - 1;
		// the main loop
		for (int i=2; i<arr.length-1; i = i + 2){
			comparisons++;
			if (arr[i] > arr[i+1]){
				comparisons++;
				if (arr[i] > max2){
					comparisons++;
					if (arr[i] > max1){
						comparisons++;
						if (max1 > arr[i+1])// max2 = max(max1, arr[i+1])
							max2 = max1; 
						else{
							max2 = arr[i+1];
						}
						max1 = arr[i];
					}
					else{
						max2 = arr[i];
					}
				}
			}
			else{
				comparisons++;
				if (arr[i+1] > max2){
					comparisons++;
					if (arr[i+1] > max1){
						comparisons++;
						if (max1 > arr[i]){//max2 = max(max1, arr[i])
							max2 = max1;
						}
						else{
							max2 = arr[i];
						}
						max1 = arr[i+1];
					}
					else{
						max2 = arr[i+1];
					}
				}
			}
		}
		comparisons++;
		if (arr.length%2 != 0){
			comparisons++;
			if (arr[arr.length-1] > max1){
				max2 = max1;
				max1 = arr[arr.length-1];
			}
			else {
				comparisons++;
				if (arr[arr.length-1] > max2) max2 = arr[arr.length-1];
			}
		}
		// print the result:
		System.out.println("max1 = "+max1+", max2 = "+max2);
		return comparisons;
	}
	public static int[] twoMaxRecurs(int arr[]){
		int[] ans = twoMaxRecurs(arr, 0, arr.length);
		//System.out.println("recurs:  max1 = "+ans[0]+", max2 = "+ans[1]);
		return ans;
	}
	public static int[] twoMaxRecurs(int arr[], int low, int high){
		if (high == low+2){
			int max1 = arr[low];
			int max2 = arr[low+1];
			if (max1 < max2){
				max1 = arr[low+1];
				max2 = arr[low];
			}
			int maxArray[] = {max1, max2, 1};
			return maxArray;
		}
		else if (high == low +1){
			int max1 = arr[low];
			int maxArray[] = {max1, Integer.MIN_VALUE, 0};
			return maxArray;
		}
		else{
			int mid =(low + high)/2; 
			int [] mL = twoMaxRecurs(arr, low, mid);// [low, mid)
			int [] mH = twoMaxRecurs(arr, mid, high);//[mid, high)
			//maxArray[0] = max1, maxArray[1] = max2, maxArray[2] = comparisons
			int maxArray[] = new int[3];
			int comp = mL[2] + mH[2];
			int i = 0, j = 0;
			comp++;
			if (mL[i] > mH[j]){
				maxArray[0] = mL[i++];
			}
			else{
				maxArray[0] = mH[j++];
			}
			comp++;
			if (mL[i] > mH[j]){
				maxArray[1] = mL[i];
			}
			else{
				maxArray[1] = mH[j];
			}			
			maxArray[2] = comp;
			return maxArray;
		}
	}
	public static void checkTimes(){
		int size = 1000000;
		long start, end, loop = 64;
		int comp1 = 0, comp2 = 0, comp3 = 0, comp4 = 0, comp5 = 0;
		double diff1 = 0, diff2 = 0, diff3 = 0, diff4 = 0, diff5 = 0;
		System.out.println("size = " + size + ";  loop = " + loop);
		for (int i = 1; i<=loop; i++){
			int arr[] = MyLibrary.randomIntArrayOfDiffNumbers(size);
			
			// two max recursive 
			start = System.currentTimeMillis();
			comp1 = comp1 + twoMaxRecurs(arr)[2];
			end = System.currentTimeMillis();
			diff1 = diff1 + ((double)(end - start))/1000.0;
			
			/// twoMaxGreatThanMax1 
			start = System.currentTimeMillis();
			comp2 = comp2 + twoMaxGreatThanMax1(arr);
			end = System.currentTimeMillis();
			diff2 = diff2 + ((double)(end - start))/1000.0;

			/// twoMaxGreatThanMax2 
			start = System.currentTimeMillis();
			comp3 = comp3 + twoMaxGreatThanMax2(arr);
			end = System.currentTimeMillis();
			diff3 = diff3 + ((double)(end - start))/1000.0;

			/// twoMaxPairs1 
			start = System.currentTimeMillis();
			comp4 = comp4 + twoMaxPairs1(arr);
			end = System.currentTimeMillis();
			diff4 = diff4 + ((double)(end - start))/1000.0;

			/// twoMaxPairs2 
			start = System.currentTimeMillis();
			comp5 = comp5 + twoMaxPairs2(arr);
			end = System.currentTimeMillis();
			diff5 = diff5 + ((double)(end - start))/1000.0;
		}
		System.out.println("twoMaxRecurs");
		System.out.printf("time twoMaxRecurs: %7.3f", diff1/loop);
		System.out.println(";  number of comparisons: " + comp1/loop);
		System.out.println();
		
		System.out.println("twoMaxGreatThanMax1");
		System.out.printf("time twoMaxGreatThanMax1: %7.3f", diff2/loop);
		System.out.println(";  number of comparisons: "+comp2/loop);
		System.out.println();

		System.out.println("twoMaxGreatThanMax2");
		System.out.printf("time twoMaxGreatThanMax2: %7.3f", diff3/loop);
		System.out.println(";  number of comparisons: "+comp3/loop);
		System.out.println();

		System.out.println("twoMaxPairs1 (great than max1)");
		System.out.printf("time twoMaxPairs1: %7.3f", diff4/loop);
		System.out.println(";  number of comparisons: "+comp4/loop);
		System.out.println();
		
		System.out.println("twoMaxPairs2 (great than max2)");
		System.out.printf("time twoMaxPairs2: %7.3f", diff5/loop);
		System.out.println(";  number of comparisons: "+comp5/loop);
		System.out.println();			
	}
	public static void checkCorrectness(){
		int []arr = {4,3,6,5,8,7,9};
		int comparisons = twoMaxPairs1(arr);
		System.out.println("loop comparisons = "+comparisons);
		twoMaxRecurs(arr);
	}
	public static void checkTimesSortedAssending(){//Ascending
		System.out.println("two max sorted ascending");
		int size = 32768;//100000;
		int []arr = new int[size];
		for (int i=0; i<size; i++){
			arr[i] = i+1; //size - i;
			//arr[i+1] = i;
		}
		// two max recursive 
		long start = System.currentTimeMillis();
		int comp = twoMaxRecurs(arr)[2];
		long end = System.currentTimeMillis();
		double diff = ((double)(end - start))/1000.0;
		System.out.println("twoMaxRecurs");
		System.out.printf("time twoMaxRecurs: %7.3f", diff);
		System.out.println(";  number of comparisons: " + comp);
		System.out.println();
		
		// two max pairs1 
		start = System.currentTimeMillis();
		comp = twoMaxPairs1(arr);
		end = System.currentTimeMillis();
		diff = ((double)(end - start))/1000.0;
		System.out.println("twoMaxPairs1");
		System.out.printf("time twoMaxPairs1: %7.3f", diff);
		System.out.println(";  number of comparisons: " + comp);
		System.out.println();
		
		// two max pairs2 
		start = System.currentTimeMillis();
		comp = twoMaxPairs2(arr);
		end = System.currentTimeMillis();
		diff = ((double)(end - start))/1000.0;
		System.out.println("twoMaxPairs2");
		System.out.printf("time twoMaxPairs2: %7.3f", diff);
		System.out.println(";  number of comparisons: " + comp);
		System.out.println();
	}
	public static void checkTimesSortedDescending(){//Descending
		System.out.println("two max sorted descending");
		int size = 32768;//100000;
		int []arr = new int[size];
		for (int i=0; i<size; i++){
			arr[i] = i+1; //size - i;
			//arr[i+1] = i;
		}
		// two max recursive 
		long start = System.currentTimeMillis();
		int comp = twoMaxRecurs(arr)[2];
		long end = System.currentTimeMillis();
		double diff = ((double)(end - start))/1000.0;
		System.out.println("twoMaxRecurs");
		System.out.printf("time twoMaxRecurs: %7.3f", diff);
		System.out.println(";  number of comparisons: " + comp);
		System.out.println();
		
		// two max pairs1 
		start = System.currentTimeMillis();
		comp = twoMaxPairs1(arr);
		end = System.currentTimeMillis();
		diff = ((double)(end - start))/1000.0;
		System.out.println("twoMaxPairs1");
		System.out.printf("time twoMaxPairs1: %7.3f", diff);
		System.out.println(";  number of comparisons: " + comp);
		System.out.println();
		
		// two max pairs2 
		start = System.currentTimeMillis();
		comp = twoMaxPairs2(arr);
		end = System.currentTimeMillis();
		diff = ((double)(end - start))/1000.0;
		System.out.println("twoMaxPairs2");
		System.out.printf("time twoMaxPairs2: %7.3f", diff);
		System.out.println(";  number of comparisons: " + comp);
		System.out.println();
	}
	// 
	public static void main(String[] args) {
		// two largest elements		
		checkCorrectness();
		//checkTimes();
		//checkTimesSortedAssending();
		//checkTimesSortedDescending();
	}
}
/** the results:
size = 100000;  loop = 100
twoMaxRecurs
time twoMaxRecurs:   0,004;  number of comparisons: 165534

twoMaxGreatThanMax1
time twoMaxGreatThanMax1:   0,000;  number of comparisons: 199984

twoMaxGreatThanMax2
time twoMaxGreatThanMax2:   0,000;  number of comparisons: 100019

twoMaxPairs1 (great than max1)
time twoMaxPairs1:   0,000;  number of comparisons: 149998

twoMaxPairs2 (great than max2)
time twoMaxPairs2:   0,000;  number of comparisons: 100030

two max sorted ascending
twoMaxRecurs
time twoMaxRecurs:   0,003;  number of comparisons: 165534

twoMaxPairs1
time twoMaxPairs1:   0,000;  number of comparisons: 149998

twoMaxPairs2
time twoMaxPairs2:   0,000;  number of comparisons: 199997

two max sorted descending
twoMaxRecurs
time twoMaxRecurs:   0,004;  number of comparisons: 165534

twoMaxPairs1
time twoMaxPairs1:   0,000;  number of comparisons: 149998

twoMaxPairs2
time twoMaxPairs2:   0,000;  number of comparisons: 199997


 **/
