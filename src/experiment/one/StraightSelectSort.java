package experiment.one;

public class StraightSelectSort {
	public int[] sort(int[] data){
		int length = data.length;
		if(length<=1){
			return data;
		}
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				//将i位置的数和j位置的数进行比较，如果j比i小，则交换位置
				if(data[j]<data[i]){
					int tamp = data[i];
					data[i] = data[j];
					data[j] = tamp;
				}
			}
			if(i==4){
				for (int datum : data) {
					System.out.print(datum+" ");
				}
			}
		}
		return data;
	}
	public static void main(String[] args) {
		int[] a = {5,3,1,9,8,2,4,7};
		StraightSelectSort selectSort = new StraightSelectSort();
		System.out.print("排序前：");
		for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.println();
		a = selectSort.sort(a);
		System.out.println();
		System.out.print("排序后：");
		for (int i : a) {
			System.out.print(i+" ");
		}
	}

}
