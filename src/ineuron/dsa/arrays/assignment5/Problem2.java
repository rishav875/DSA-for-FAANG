package ineuron.dsa.arrays.assignment5;

public class Problem2 {
	/*
	 You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check. Since each
version is developed based on the previous version, all the versions after a bad version
are also bad. Suppose you have n version and you want to find out the first bad one,
which causes all the following ones to be bad. Also, talk about the time complexity of
your code.
Test Cases:
Input: [0,0,0,1,1,1,1,1,1]
Output: 3
Explanation: 0 indicates a good version and 1 indicates a bad version. So, the index of
the first 1 is at 3. Thus, the output is 3
	 */
	
	public static void main(String[] args) {
		int[] arr= {0,0,0,1,1,1,1,1,1};
		int start=0;
		int end=arr.length-1;
		int key=1;
		
		System.out.println(binarySearch(arr, start, end, key));
	}
	//Time Complexity=O(logn)
	static int binarySearch(int[] arr, int start, int end, int key) {
		int index=-1;
		
		while(start<=end) {
			
			int mid=start+(end-start)/2;
			
			if( arr[mid]==key && (mid==0 || arr[mid-1]<key)) {
				return mid;
			}
			
			if(arr[mid]<key)
				return binarySearch(arr,mid+1,end,key);
			else
				return binarySearch(arr,start,mid-1,key);
			
		}
		
		return index;
	}

}
