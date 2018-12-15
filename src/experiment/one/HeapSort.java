package experiment.one;

public class HeapSort {
	public int[] sort(int[] data){
		int length = data.length;
		int lastIndex = length-1;
		buildMaxHeap(data, lastIndex);//建立最大堆
		while(lastIndex>0){
			swap(data, 0, lastIndex);
			if(--lastIndex==0){   //只剩一个元素就退出
				break;
			}
			adjustHeap(data, 0, lastIndex);//对剩下的节点，进行调整以构建最大堆
		}
		return data;
	}

	//建立最大堆
	public void buildMaxHeap(int[] data,int lastIndex){
		// 从最后一个元素的父节点开始进行调整，一直调整到根节点结束
		int j = (lastIndex-1)/2;
		while(j>=0){
			int rootIndex = j;
			adjustHeap(data, rootIndex, lastIndex);
			j--;
		}
	}

	//调整最大堆，从根节点开始往下调整
	public void adjustHeap(int[] data,int rootIndex,int lastIndex){
		int biggerIndex = rootIndex;
		int leftChildIndex = rootIndex*2+1;
		int rightChildIndex = rootIndex*2+2;
		if(rightChildIndex<=lastIndex){//保存右节点存在
			if(data[rightChildIndex]>data[rootIndex]
					||data[leftChildIndex]>data[rootIndex]){
				//将子节点更大的下标赋给biggerIndex
				biggerIndex = data[leftChildIndex]>data[rightChildIndex]?leftChildIndex:rightChildIndex;
			}
		}else if(leftChildIndex<=lastIndex){//保证左节点存在且不能越界
			if(data[leftChildIndex]>data[rootIndex]){
				biggerIndex=leftChildIndex;
			}
		}
		if(biggerIndex!=rootIndex){
			swap(data, rootIndex, biggerIndex);
			adjustHeap(data, biggerIndex, lastIndex);
		}
	}

	//交换根节点跟末节点的值
	public void swap(int[] data,int rootIndex,int biggerIndex){
		int temp = data[rootIndex];
		data[rootIndex] = data[biggerIndex];
		data[biggerIndex] = temp;
	}

	public static void main(String[] args) {
		//int[] a = {5,3,1,9,8,2,4,7};
		int[] a = {5,1,7,4,9,6,3,13,8,14,2,0,24};
		HeapSort heapSort = new HeapSort();
		System.out.print("排序前：");
		for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.println();
		a = heapSort.sort(a);
		System.out.print("排序后：");
		for (int i : a) {
			System.out.print(i+" ");
		}
	}

}
