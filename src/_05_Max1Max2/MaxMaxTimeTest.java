package _05_Max1Max2;

public class MaxMaxTimeTest {

	public static void twoMaxGreatThanMax1(int[] arr){//2n comparisons
		// initialization
		int max1 = arr[0];
		int max2 = arr[1];
		if (max1 < max2){
			max1 = arr[1];
			max2 = arr[0];
		}
		// the main loop
		for (int i=2; i<arr.length; i++){
			// the first comparison
			if(arr[i] > max1){
				max2=max1;
				max1=arr[i];
			}
			else{
				if(arr[i]>max2){
					max2=arr[i];
				}
			}
		}
		// the result:
		//System.out.println("max1 = "+max1+", max2 = "+max2);
		//return comparisons;
	}
	public static void twoMaxPairs1(int[] arr){//(3/2)*n comparisons
		// initialization
		int max1 = arr[0];
		int max2 = arr[1];
		if (max1 < max2){
			max1 = arr[1];
			max2 = arr[0];
		}
		// the main loop
		for (int i=2; i<arr.length-1; i=i+2){
			int ai=arr[i], aip1 = arr[i+1];
			if (ai > aip1){
				if (ai > max1){
					/// max2 = max(max1, arr[i+1])
					if (max1 > aip1){
						max2 = max1;
					}
					else{
						max2 = aip1;
					}
					max1 = ai;
				}
				else{
					if (ai > max2) max2 = ai;
				}
			}
			else{
				if (aip1 > max1){
					/// max2 = max(max1, arr[i])
					if (max1 > ai){
						max2 = max1;
					}
					else{
						max2 = ai;
					}
					max1 = aip1;
				}
				else{
					if (aip1 > max2) max2 = aip1;
				}
			}
		}
/*		if (arr.length%2 != 0){
			if (arr[arr.length] > max1){
				max2 = max1;
				max1 = arr[arr.length];
			}
			else {
				if (arr[arr.length] > max2) max2 = arr[arr.length];
			}
		}
		// print the result:
*/		//System.out.println("max1 = "+max1+", max2 = "+max2);
	}
	public static void main(String[] args) {
		long start, end;
		int size = 1000000, n=100;
		double ti1=0, ti2=0;
		for (int i = 0; i < n; i++) {
			int[] arr = MyLibrary.randomIntArrayOfDiffNumbers(size);
			/// twoMaxGreatThanMax1 
			start = System.currentTimeMillis();
			twoMaxGreatThanMax1(arr);
			end = System.currentTimeMillis();
			long time =  end - start;
			ti1 = ti1 + time;
			////////////
			/// twoMaxPairs1 
			start = System.currentTimeMillis();
			twoMaxPairs1(arr);
			end = System.currentTimeMillis();
			time = end - start;
			ti2 = ti2 + time;
		}
		System.out.println("time twoMaxGreatThanMax1, 2n comparisons: " + ti1/n);
		System.out.println("time twoMaxPairs, 1.5n comparisons: " + ti2/n);
	}
}
/**
 * time twoMaxPairs, 1.5n comparisons: 3.24
 * time twoMaxGreatThanMax1, 2n comparisons: 4.08
 * 
   time twoMaxGreatThanMax1, 2n comparisons: 3.3
   time twoMaxPairs, 1.5n comparisons: 4.11

 * */
