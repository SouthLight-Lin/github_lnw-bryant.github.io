package experiment.one;

public class MyHeapSort {
    //排序
    public void sort(int[] a){
        int lastIndex = a.length-1;
        while (lastIndex>0){
            buildHeap(a,lastIndex);
            swap(a,0,lastIndex);
            lastIndex--;
        }
    }

    /**
     * 建堆
     * @param a
     * @param lastIndex
     */
    public void buildHeap(int[] a,int lastIndex){
        if(lastIndex==0){
            return;
        }
        //父节点
        int fatherIndex = (lastIndex-1)/2;
        while(fatherIndex>=0){
            buildFatherAndChild(a,fatherIndex,lastIndex);
            fatherIndex--;
        }
    }


    //从当前父节点开始向下构建最大堆
    public void buildFatherAndChild(int[] a,int fatherIndex,int lastIndex){
        int leftChildIndex = fatherIndex*2+1;   //左孩子节点
        int rightChildIndex = fatherIndex*2+2;  //右孩子节点
        int biggerIndex = fatherIndex;          //存储左右孩子节点中较大的下标
        //判断左右孩子节点是否符合范围
        if(rightChildIndex<=lastIndex){
            if(a[fatherIndex]<a[rightChildIndex]||a[fatherIndex]<a[leftChildIndex])
                biggerIndex=a[rightChildIndex]>a[leftChildIndex]?rightChildIndex:leftChildIndex;
        }else if (leftChildIndex<=lastIndex){
            if(a[fatherIndex]<a[leftChildIndex])
                biggerIndex=leftChildIndex;
        }
        if (biggerIndex!=fatherIndex){
            swap(a,fatherIndex,biggerIndex);
            buildFatherAndChild(a,biggerIndex,lastIndex);
        }
    }

    public void swap(int[] a,int rootIndex,int lastIndex){
        int temp = a[rootIndex];
        a[rootIndex] = a[lastIndex];
        a[lastIndex] = temp;
    }

    public static void main(String[] args) {
        int[] a = {5,1,7,4,9,6,3,13,8,14,2,0,24};
        MyHeapSort heapSort = new MyHeapSort();
//        heapSort.buildHeap(a,a.length-1);
//        for(int i:a){
//            System.out.print(i+" ");
//        }
        System.out.print("排序前：");
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
        heapSort.sort(a);
        System.out.print("排序后：");
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
