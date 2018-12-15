package algorithms;

import util.MyMath;

/**
 * Quick Sort
 * @author Administrator
 *
 */
public class QuickSort {
	public static void qSort(Comparable[] a, int lo, int hi){
		if(lo<hi){
			int mid = partition(a,lo,hi);
			qSort(a,lo, mid-1);   //sort left part
			qSort(a,mid+1, hi);     //sort right part
		}
	}

	public static int partition(Comparable[] a,int lo, int hi) {
		int i=lo,j=hi+1;
		Comparable x = a[lo];
		//move <x the element to left
		//move >x the element to right
		while(true){
			while (a[++i].compareTo(x)<0 && i<hi);
			while (a[--j].compareTo(x)>0);
			if(i>=j) break;
			//switch i and j the position
			swap(a,i,j);
		}
		a[lo] = a[j];
		a[j] = x;
		return j;
	}
	
	public static void swap(Comparable[] a,int i,int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] temp = {8,4,3,7,1,5,6,2};
		Integer[] a = new Integer[temp.length];
		for(int i=0;i<temp.length;i++){
			a[i] = Integer.valueOf(temp[i]);
		}
		QuickSort.qSort(a, 0, a.length-1);
		for (Integer integer : a) {
			System.out.print(integer+"  ");
		}
		System.out.println();
		System.out.println(random(0, 10));
	}

	//随机化的快速排序算法
	private static int randomizedPartition(Comparable[] a,int p,int r){
		int i = random(p,r);
		MyMath.swap(a,i,p);
		return partition(a,p ,r);
	}

	private static void randomizedQuickSort(Comparable[] a,int p,int r){
		if(p<r){
			int q = randomizedPartition(a,p,r);
			randomizedQuickSort(a,p,q-1);
			randomizedQuickSort(a,q+1,r);
		}
	}

	private static int random(int p, int r) {
		return  r + (int)(Math.random() * ((p - r) + 1));
	}

}
