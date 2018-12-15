package experiment.six;

import java.util.Arrays;

/**
 * N皇后问题
 * @author LNW
 */
public class NQueen {
    // 皇后个数
    static int n;
    // 当前解
    static int[] x;
    // 当前已找到的可行方案数
    static long sum;

    public static void main(String[] args) {
        System.out.println(nQueen(8));
    }


    public static long nQueen(int nn){
        n = nn;
        sum = 0;
        x = new int[n+2];
        for (int i = 0; i <= n; i++) {
            x[i] = 0;
        }
        // 从位置0开始验证
        backtrack(1);
        return sum;
    }
    public static void backtrack(int t){
        if (t>n){
            for (int i = 1; i < x.length-1; i++) {
                System.out.print(x[i]+" ");
            }
            System.out.println();
            sum++;
        }
        for (int i = 1; i <=n ; i++) {
            x[t] = i;
            if (place(t)){
                backtrack(t+1);
            }
        }
    }
    // 放置目前这个位置，看是否符合要求
    public static  boolean place(int k){
        for (int j = 1; j <k ; j++) {
            if ((Math.abs(k-j)==Math.abs(x[j]-x[k])) || (x[j]==x[k])){
                return false;
            }
        }
        return true;
    }
}
