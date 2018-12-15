package algorithms;

/**
 *归并排序
 */
public class Merge {
    private static Comparable[] aux;        //辅助数组

    private static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if(low>=high) return;
        int mid = (low+high)/2;
        sort(a,low,mid);                //左半部分排序
        sort(a,mid+1,high);         //右半部分排序
        merge(a,low,mid,high);
    }

    public static void merge(Comparable[] a,int low,int mid,int high){
        int i=low;  //左半部分开始位置
        int j = mid+1;  //右半部分开始位置
        //复制数据到aux中
        for(int k=low;k<=high;k++) aux[k] = a[k];

        //归并操作
        for(int k=low;k<=high;k++){
            if(i>mid)               a[k]=aux[j++];   //左半部分用尽
            else if (j>high)        a[k]=aux[i++]; //右半部分用尽
            else if (aux[i].compareTo(aux[j])==1) a[k] = aux[j++];
            else                    a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {5,7,8,4,1,2,6,3};
        sort(a);
        for (Comparable i : a) {
            System.out.print(i+" ");
        }
    }
}
