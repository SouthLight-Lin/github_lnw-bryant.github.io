package experiment.five;

/**
 * 最小生成树
 * 使用Prim算法
 * @author LNW
 */
public class Prim {
    static  final float MAX = Float.MAX_VALUE;
    public static void main(String[] args) {

        float[][] c = {
                {0,34,Float.MAX_VALUE,Float.MAX_VALUE,12,Float.MAX_VALUE},
                {34,0,46,Float.MAX_VALUE,Float.MAX_VALUE,19},
                {Float.MAX_VALUE,46,0,17,Float.MAX_VALUE,25},
                {Float.MAX_VALUE,Float.MAX_VALUE,17,0,38,25},
                {12,Float.MAX_VALUE,Float.MAX_VALUE,38,0,26},
                {Float.MAX_VALUE,19,25,25,26,0}
        };

        float[][] t = {
                {MAX,6,1,5,MAX,MAX},
                {6,MAX,5,MAX,3,MAX},
                {1,5,MAX,5,6,4},
                {5,MAX,5,MAX,MAX,2},
                {MAX,3,6,MAX,MAX,6},
                {MAX,MAX,4,2,6,MAX}
        };
        prim(c.length,c);
    }
    public static void prim(int n,float[][] c){
        // 存放较小的权值
        float[] lowcost = new float[n];
        //存放使lowcost小的边
        int[] closet = new int[n];
        // 记录选取了的顶点
        boolean[] s = new boolean[n];
        //先放1进来，初始化lowcost和closet
        s[0] = true;
        for (int i=1;i<n;i++){
            lowcost[i] = c[0][i];
            closet[i] = 0;
            s[i] = false;
        }

        for (int i = 0; i < n; i++) {
            float min = Float.MAX_VALUE;
            int j = 0;
            for (int k = 1;k<n;k++){
                if ((lowcost[k]<min) && (!s[k])){
                    min = lowcost[k];
                    j = k;
                }
            }
            System.out.println((j)+"， "+(closet[j]));
            s[j] = true;
            for (int k = 1;k<n;k++){
                if ((c[j][k]<lowcost[k]) && (!s[k])){
                    lowcost[k] = c[j][k];
                    closet[k] = j;
                }
            }
        }
    }
}
