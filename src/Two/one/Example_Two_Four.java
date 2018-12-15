package Two.one;

import util.MyMath;

/**
 * 递归排列问题
 */
public class Example_Two_Four {
    public static void perm(Object[] list,int k,int m){
        //产生list[k:m]的所有排列
        if(k==m){
            //只剩一个元素，输出排列结果
            for(int i=0;i<=m;i++){
                System.out.print(list[i]);
            }
            System.out.println();
        }else {
            //还要很多元素
            for(int i=k;i<=m;i++){
                MyMath.swap(list, k, i);
                perm(list,k+1,m);
                MyMath.swap(list, k, i);
            }
        }
    }

    public static void main(String[] args) {
        Object[] data = new Object[]{2,9,3};
        perm(data,0,2);
    }

}
