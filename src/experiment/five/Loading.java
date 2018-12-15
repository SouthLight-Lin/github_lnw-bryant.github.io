package experiment.five;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 最优装载问题
 * 用贪心实现
 * @author LNW
 */
public class Loading {
    public static void main(String[] args) {
        float c = 100;
        float[] w = {20,50,35,35};
        int[] x = new int[w.length];
        System.out.println("集装箱总重量："+loading(c,w,x));
        int num = 0;
        for (int i : x) {
            if (i==1){
                num+=1;
            }
        }
        System.out.println("可装集装箱数量："+num);
    }

    /**
     *
     * @param c  轮船的重量
     * @param w  集装箱i的重量
     * @param x  取值（0,1）表示装不装入集装箱
     * @return
     */
    public static float loading(float c,float[] w,int[] x){
        int n = w.length;
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Element(w[i],i));
        }
        // 以升序排列
        Collections.sort(list);
        // 转化为数组
        Element[] d = new Element[list.size()];
        list.toArray();
        list.toArray(d);

        // 最优装载重量
        float opt = 0;
        for (int i = 0; i < n; i++) {
            // 初始化
            x[i] = 0;
        }
        // 不能超过轮船的载重
        for (int i = 0; i < n && d[i].w<=c; i++) {
           x[d[i].i] = 1;
           opt += d[i].w;
           // 重新计算轮船目前的载重
           c -= d[i].w;
        }

        return opt;
    }

    public static class Element implements Comparable{
        float w;
        int i;

        public Element(float w, int i) {
            this.w = w;
            this.i = i;
        }

        @Override
        public int compareTo(Object o) {
            float xw = ((Element)o).w;
            if (w<xw){
                return -1;
            }
            if (w ==xw){
                return 0;
            }
            return 1;
        }
    }
}
