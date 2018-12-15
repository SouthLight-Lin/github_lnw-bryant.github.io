package experiment.four;

/**
 * 最优二叉搜索树
 */
public class OptimalBinarySearchTree {
    public static void main(String[] args) {
        int[] n={1,2,3,4};
        int length = n.length;
        float[] a={2,3,1,1,1};
        float[] b={3,3,1,1};
//        int[] n={1,2,3};
//        int length = n.length;
//        float[] a={(float) 0.15, (float) 0.1, (float) 0.05, (float) 0.05};
//        float[] b={(float) 0.5, (float) 0.1, (float) 0.05};
        float[][] w = new float[length+2][length+2];
        float[][] m = new float[length+2][length+2];
        int[][] s = new int[length+1][length+1];
        optimalBinarySeacherTree(a,b,m,s,w);
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.print(s[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----finish-----");
    }

    public static void optimalBinarySeacherTree(float[] a,float[]b,float[][] m,int[][] s,
                                                float[][] w){
        int n = a.length-1;
        for(int i=0;i<=n;i++){
            w[i+1][i]=a[i];
            m[i+1][i]=0;
        }
        for(int r=0;r<n;r++){
            for(int i=1;i<=n-r;i++){
                int j=i+r;
                w[i][j]=w[i][j-1]+a[j]+b[j-1];
                m[i][j]=m[i+1][j];
                s[i][j]=i;
                for(int k=i+1;k<=j;k++){
                    float t = m[i][k-1]+m[k+1][j];
                    if(t<m[i][j]){
                        m[i][j]=t;
                        s[i][j]=k;
                    }
                }
                m[i][j]+=w[i][j];
            }
        }
    }
}
