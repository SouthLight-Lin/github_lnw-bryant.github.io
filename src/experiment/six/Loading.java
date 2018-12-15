package experiment.six;

/**
 * 装载问题
 * 注意：这里的下标是从1开始的，跟书一样
 * @author LNW
 */
public class Loading {
    // 集装箱数
    static int n;
    // 集装箱重量数组
    static int[] w;
    // 第一艘轮船的重量
    static int c;
    // 当前载重
    static int cw;
    // 当前最优载重量
    static int bestw;
    // 剩余集装箱重量
    static int r;
    // 当前解
    static int[] x;
    // 当前最优解
    static int[] bestx;

    public static void main(String[] args) {
        int[] ww = {0,20,40,30,50};
        int[] xx = new int[ww.length];
        int cc = 100;
        maxLoading(ww,cc,xx);
        for (int i = 1; i < bestx.length; i++) {
            System.out.print(bestx[i]+" ");
        }
    }


    public static int maxLoading(int[] ww,int cc,int[] xx){
        // 初始化变量
        n = ww.length-1;
        w = ww;
        c = cc;
        cw = 0;
        bestw = 0;
        x = new int[n+1];
        bestx = xx;

        // 初始化r
        for (int i = 1; i <= n ; i++) {
            r+=w[i];
        }
        //计算最优载重量
        // 从根节点开始
        backtrack(1);
        return bestw;
    }

    // 回溯算法
    public static void backtrack(int i){
        // 如果到达叶节点，就表示此时的活节点结束
        if (i>n){
            if (cw>bestw){
                for (int j = 1; j <=n ; j++) {
                    bestx[j] = x[j];
                }
                bestw = cw;
            }
            return;
        }

        // 搜索子树
        // 不管选不选都先装上，因为r只是剩余的集装箱重量
        r-=w[i];
        // 搜索左子树
        if (cw+w[i]<=c){
            x[i] = 1;
            cw+=w[i];
            // 搜索下个节点
            backtrack(i+1);
            // 恢复原状
            cw-=w[i];
        }
        // 如果当前载重+剩余的集装箱还大于最优载重
        // 表示还有其他可能
        if (cw+r>bestw){
            // 回复原状
            x[i] = 0;
            backtrack(i+1);
        }
        // 把原先减掉的r加回去，这样退回到活节点的时候才能回复原状
        r+=w[i];

    }
}
