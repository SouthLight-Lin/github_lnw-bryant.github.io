package experiment.four;

/**
 * 0-1背包问题
 */
public class Knapsack {
    public static void main(String[] args) {
//        int c=16;
//        int[] w={7,8,9};
//        int[] v={20,25,30};
//        int[] x = new int[v.length];
//        int[][] m = new int[v.length][c+1];
//        knapsack(v,w,c,m);
//        traceback(m,w,c,x);
//        System.out.println("----finish-----");

        int[] v={20,25,30};
        int[] x = new int[v.length];
        double[] dw = {0.7,0.8,0.9};
        double dc = 1.6;
        int Z = 1;
        while (!isInt(dc)){
            Z*=10;
            dc*=Z;
        }
        int c = (int) (dc);
        int[] w = processDoubleToInt(dw,Z);
        int[][] m=new int[v.length][c+1];
        knapsack(v,w,c,m);
        traceback(m,w,c,x);
        System.out.println("最优解->"+m[0][c]);
        System.out.print("x->");
        for (int i : x) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("----finish-----");
    }

    public static void knapsack(int[] v,int[] w,int c,int[][] m){
        int n = v.length-1;
        int jMax = Math.min(w[n]-1,c);
        for (int j = 0; j <=jMax; j++) {
            m[n][j]=0;
        }
        for (int j = w[n]; j <=c; j++) {
            m[n][j]=v[n];
        }

        for (int i = n-1; i > 0; i--) {
            jMax = Math.min(w[i]-1,c);
            for (int j = 0; j <=jMax ; j++) {
                m[i][j]=m[i+1][j];
            }
            for (int j = w[i]; j <=c; j++) {
                m[i][j] = Math.max(m[i+1][j],m[i+1][j-w[i]]+v[i]);
            }
        }
        m[0][c]=m[1][c];
        if(c>=w[0])
            m[0][c]=Math.max(m[0][c],m[1][c-w[0]]+v[0]);
    }

    public static void traceback(int[][] m,int[] w,int c,int[] x){
        int n=w.length-1;
        for (int i = 0; i <n; i++) {
            if(m[i][c]==m[i+1][c])
                x[i]=0;
            else {
                x[i]=1;
                c-=w[i];
            }
            x[n]=(m[n][c]>0)?1:0;
        }
    }

    public static int[] processDoubleToInt(double[] dw,int Z){
        int[] x = new int[dw.length];
        for (int i = 0; i < dw.length; i++) {
            x[i] = (int) (dw[i]*Z);
        }
        return x;
    }

    public static boolean isInt(double d){
        Double D = new Double(d);
        String num = D.toString();
        String last = num.substring(num.lastIndexOf(".")+1);
        if("0".equals(last)){
           return true;
        }
        return false;
    }
}
