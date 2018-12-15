package algorithms;
/**
 * Binary Search 
 * @author Administrator
 *
 */
public class BinarySearch {
	//Sort the array firstly
	//this using Quick sort
	void sort(Comparable[] a){
		new QuickSort().qSort(a, 0, a.length-1);
	}
	
	//return the position x in array 
	int search(Comparable x,Comparable[] a){
		//sort the array
		sort(a);
		int left = 0;
		int right = a.length-1;
		while(left<=right){
			int mid = (left+right)/2;
			if(x==a[mid]) return mid;
			if(x.compareTo(a[mid])>0) left = mid+1;
			else         right = mid-1;
		}
		return -1;
	}
	
	//return the min position max x in array 
	int searchMax(Comparable x,Comparable[] a){
		int left = 0;
		int right = a.length-1;
		while(left<=right){
			int mid  = (left+right)/2;
			if(x.compareTo(a[mid])<0&&x.compareTo(a[mid-1])>0) return mid;
			if(x.compareTo(a[mid])>0)  left = mid+1;
			if(x.compareTo(a[mid])<0)  right = mid-1;
		}
		return -1;
	}
	
	//return the max position min element x in array 
	int searchMin(Comparable x,Comparable[] a){
		int left = 0;
		int right = a.length-1;
		while(left<=right){
			int mid  = (left+right)/2;
			if(x.compareTo(a[mid])>0&&x.compareTo(a[mid+1])<0) return mid;
			if(x.compareTo(a[mid])<0)  right = mid-1;
			if(x.compareTo(a[mid])>0)  left =  mid+1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] temp = {-15,-6,0,7,9,23,54,82,101};
		Integer[] a = new Integer[temp.length];
		for(int i=0;i<temp.length;i++){
			a[i] = Integer.valueOf(temp[i]);
		}
		BinarySearch search = new BinarySearch();
		int result = search.search(30, a);
		if(result==-1){
			System.out.println(search.searchMax(30, a));
			System.out.println(search.searchMin(30,a));
		}
		System.out.println(result);
	}
}
