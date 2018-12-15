package util;

public class MyMath {
    //将k位置和i位置的结果互换
    public static void swap(Object[] list,int k,int i){
        Object x = list[k];
        list[k] = list[i];
        list[i] = x;
        x = null;
    }
}
