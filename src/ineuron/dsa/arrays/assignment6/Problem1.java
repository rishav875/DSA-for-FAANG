package ineuron.dsa.arrays.assignment6;


public class Problem1 {
	/*
	 arr = [1, 3, 7, 9, 12, 10, 8, 16, 18, 22, 27]
	Create a buildHeap method that returns a minheap.

heapify(arr, n, i):
	// Write your own code

buildHeap(arr, n):
	//Write your own code
	heapify(arr, n, i)

	 */
	
	/*
	 Note:
	 Arr[(i -1) / 2] returns its parent node.
	 Arr[(2 * i) + 1] returns its left child node.
	 Arr[(2 * i) + 2] returns its right child node.
	 */
	
	/*
	 * Time Complexity of building Heap= O(n)
	 * Space Complexity= O(n)
	 */
	private static int[] minHeap;
	
	public static void main(String[] args) {
		
		
		int[] arr = {100, 13, 7, 9, 12, 10, 8, 16};
		int size=arr.length;
		minHeap=new int[size];
		buildHeap(arr,size);
		
		
		for(int i=0;i<size;i++) {
			String coma=i!=size-1? ",":"";
		System.out.print(minHeap[i]+ coma);
		}	
	}
	static void buildHeap(int[] arr,int n) {
		
		
		for(int j=0;j<n;j++) {
			heapify(arr[j],j);
		}
	}
	
	
	
	static void swap(int[] arr,int index1, int index2 ) {
		
		int temp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;
	}

	static void heapify(int value,int index) {
		
		minHeap[index]=value;
		
		while(minHeap[index]<minHeap[(index-1)/2]) {
			swap(minHeap,index,(index-1)/2);
			index/=2;
		}
	}
}
