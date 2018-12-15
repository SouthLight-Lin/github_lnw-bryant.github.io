package algorithms;
/**
 * 冒泡排序
 */
public class BubbleSort {
	public int[] sort(int[] data){
		int length = data.length;
		if(length==0||length==1){
			return data;
		}
		for(int i=0;i<length-1;i++){
			for(int j=0;j<length-1-i;j++){
				//如果前一个数比后一个数大，就交换位置
				if(data[j]>data[j+1]){
					int x = data[j];
					data[j] = data[j+1];
					data[j+1] = x;
				}
			}
			if(i==1){
				for (int datum : data) {
					System.out.print(datum+" ");
				}
			}
		}
		return data;
	}

	public static void main(String[] args) {

		int[] a = {5,3,1,9,8,2,4,7};
		BubbleSort bubbleSort = new BubbleSort();
		System.out.print("排序前：");
		for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.println();
		a = bubbleSort.sort(a);
		System.out.println();
		System.out.print("排序后：");
		for (int i : a) {
			System.out.print(i+" ");
		}
	}

}
