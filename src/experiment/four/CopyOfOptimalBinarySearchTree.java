package experiment.four;

public class CopyOfOptimalBinarySearchTree {

    public static void main(String[] args) {
        //p[1,5]是5个实节点的概率 p[0]不存在
        double[] p = {
                0,3,3,1,1
        };
        //q[0,5]是6个虚节点的概率
        double[] q= {
                2,3,1,1,1
        };
        //共5个
        int n = p.length - 1;
        //root[i][j]记录的是最终得出的[i,j]这个子段里的根节点
        int[][] root = Optimal_BST(p,q,n);
        //root的length是n+2,i和j只需要循环到n
        int temp = root.length - 1;
        //输出一下这个root矩阵，直接根据这个矩阵也可以自己画出来最优二叉搜索树了
        for(int i  = 1;i < temp; i++) {
            for(int j = 1; j < temp; j++) {
                System.out.print(root[i][j] + "-");
            }
            System.out.println();
        }
    }

    private static int[][] Optimal_BST(double[] p, double[] q, int n) {
        //e[i][j]表示i到j这段的代价
        //e[1][0]为左边虚节点d0的代价...e[n+1][n]为左边虚节点dn的代价
        double[][] e= new double[n+2][n+2];
        //i到j这一段的总概率，在加一层根节点时需要用到
        double[][] w= new double[n+2][n+2];
        //root[i][j]记录的是最终得出的[i,j]这个子段里的根节点
        int[][] root= new int[n+2][n+2];

        //初始化
        for(int i = 1; i < n + 1; i++) {
            e[i][i-1] = q[i-1];
            w[i][i-1] = q[i-1];
        }
        //这段代码需要好好理解
        //l是 [i,j]的长，相当于一个固定l长度的小节从最左边循环到最右边。然后再把l逐渐加大，重复从左到右。这样就使得小长度的都先计算过，为大长度的片段分解为左右两个字片段计算时提供了已经计算好的值，这也是动态规划的精髓之一。
        //这样做是为了从小到大积累动态规划的能量
        for(int l = 1; l <= n; l++) {
            for (int i = 1; i <= n-l+1; i++) {
                int j = i + l - 1;
                //先设为最大值，最后才能找出真正最小的，从而找到最优解
                e[i][j] = Double.MAX_VALUE;
                //w的递归，很容易理解
                w[i][j] = w[i][j-1] + p[j] + q[j];
                //从i到j找到最优的根节点
                for(int r = i; r <= j; r++) {
                    //加了一层，相当于下面的左子树右子树都加了一布，其实就是最终比没加一层根节点比多了一个w[i][j]
                    double t = e[i][r-1] + e[r+1][j] + w[i][j];
                    //不断的使e[i][j]保持最小，同时记录使代价最小的位置为最终最优的根节点
                    if(t < e[i][j]) {
                        e[i][j] = t;
                        root[i][j] = r;
                    }
                }
            }

        }
        System.out.println("当前最小代价：" + e[1][n]);
        return root;
    }
}

