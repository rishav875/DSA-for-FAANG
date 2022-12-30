package ineuron.dsa.arrays.assignment7;

public class Problem2 {
	/*
	 2. Given three points, check whether they lie on a straight (collinear) or not. [Google]
For example:
Input- [(1,1), (1,6), (0,9)]
Output- No
Input- [(1,1), (1,4), (1,5)]
Output- Yes
	 */
	
	public static void main(String[] args) {
		int[][] arr= {{1,1},{1,4},{1,5}};
		
		String ans= collinerOrNotApproach1(arr);
		System.out.println(ans);
	}
//Approach1: The slope will be same. 
	/*
	 (x2-x1)*(y3-y2)=(x3-x2)(y2-y1)
	 */
	//Time Complexity= O(1)
	private static String collinerOrNotApproach1(int[][] arr) {
		
		String ans="NO";
		
		int m1=(arr[1][0]-arr[0][0])*(arr[2][1]-arr[1][1]);
		int m2=(arr[2][0]-arr[1][0])*(arr[1][1]-arr[0][1]);
		
		if(m1==m2)
			ans="YES";
		
		
		return ans;
		
	}


}
