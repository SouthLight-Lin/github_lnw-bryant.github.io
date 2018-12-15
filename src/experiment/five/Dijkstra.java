package experiment.five;

/**
 * 单元最短路径问题
 * @author LNW
 */
public class Dijkstra {
    public static void main(String[] args) {
        int[] point = {0,1,2,3,4};
        int v = 0;
        float[][] a = {{0,3,Float.MAX_VALUE,Float.MAX_VALUE,30},
                       {Float.MAX_VALUE,0,25,8,Float.MAX_VALUE},
                       {Float.MAX_VALUE,Float.MAX_VALUE,0,Float.MAX_VALUE,10},
                       {20,Float.MAX_VALUE,4,0,12},
                       {5,Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE,0}
        };
//        float[][] a = {{0,10,Float.MAX_VALUE,30,100},
//                {Float.MAX_VALUE,0,50,Float.MAX_VALUE,Float.MAX_VALUE},
//                {Float.MAX_VALUE,Float.MAX_VALUE,0,Float.MAX_VALUE,10},
//                {Float.MAX_VALUE,Float.MAX_VALUE,20,0,60},
//                {Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE,0}
//        };
        float[] dist = new float[point.length];
        int[] prev = new int[point.length];
        dijkstra(v,a,dist,prev);

        for (int i=0;i<point.length;i++){
            System.out.println("V0到V"+i+":");
            traceback(point,prev,i);
            System.out.println("V"+point[i]);

        }


        System.out.println("-----Dijkstra finish-----");
    }

    /**
     * 算法
     * @param v     源点
     * @param a     边(i,j)的权
     * @param dist  表示从当前源到顶点的最短路径
     * @param prev  在最短路径中，每个点（出源点）的前一个点
     */
    public static void dijkstra(int v,float[][] a,float[] dist,int[] prev){
        int n = dist.length-1;
        if (v<0 || v>n-1){
            return;
        }
        boolean[] s = new boolean[dist.length];
        //初始化
        //找出有个顶点连接的点，没有的话就在prev数组里面赋值-1
        for (int i=0;i<=n;i++){
            dist[i] = a[v][i];
            s[i] = false;
            if (dist[i]==Float.MAX_VALUE) {
                prev[i] = -1;
            }
            else {
                prev[i] = v;
            }
        }
        dist[v] = 0;
        s[v] = true;
        //从顶点开始，寻找到每个点的最短路径
        for (int i=0;i<=n;i++){
            float temp = Float.MAX_VALUE;
            //顶点是v
            int u = v;
            //顶点v到j点的距离，跟dist[j]中的值做比较（j还没在s中）
            for (int j = 0;j<=n;j++){
                if ((!s[j]) && (dist[j]<temp)){
                    u = j;
                    temp = dist[j];
                }
            }
            s[u] = true;
            //加入u点到s后，看是否可更新最短路径
            for (int j=0;j<=n;j++){
                if ((!s[j]) && (a[u][j]<Float.MAX_VALUE)){
                    float newdist = dist[u]+a[u][j];
                    if (newdist<dist[j]){
                        //dist[j] 减少
                        dist[j] = newdist;
                        prev[j] = u;
                    }
                }
            }
        }
    }

    public static void traceback(int[] point,int[] prev,int n){
        if (n==0){
            return;
        }
        traceback(point,prev,prev[n]);
        System.out.print("V"+point[prev[n]]+" ");
    }
}
