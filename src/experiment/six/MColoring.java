package experiment.six;

/**
 * @author LNW
 * 图的M着色问题
 */
public class MColoring {
	static int n;   		// 图的定点数
	static int m;   		// 可用颜色数
	static int[][] a; 	// 图的邻接矩阵
	static int[] x;			// 当前解
	static long sum;		// 当前已找到的可m着色方案数
	
	public static void main(String[] args) {
		int[][] aa = {
				{0,1,0,1,1},
				{1,0,1,0,1},
				{0,1,0,1,0},
				{1,0,1,0,1},
				{1,1,0,1,0}
		};
		int[][] test = {
				{0,1,1,1,0},
				{1,0,1,1,1},
				{1,1,0,1,0},
				{1,1,1,0,1},
				{0,1,0,1,0}
		};
		int[] xx = new int[aa.length];
		// 可选颜色数
		int mm = 4;
		int nn = aa.length;
		System.out.println(mColoring(mm, nn, aa, xx));
	}
	
	
	public static long mColoring(int mm,int nn,int[][] aa,int[] xx){
		m = mm;n = nn;a = aa;x = xx;
		sum = 0;
		backtrack(0);
		return sum;
	}
	
	public static void backtrack(int t){
		// 如果到达叶结点
		if(t>n-1){
			sum++;
			for(int i=0;i<n;i++){
				System.out.print(x[i]+" ");
			}
			System.out.println();
		}
		else{
			// 选择颜色
			for(int i=1;i <= m;i++){
				x[t] = i;
				// 判断现在所选的颜色是否符合要求
				if(ok(t)){
					// 如果符合要求，进行下个
					backtrack(t+1);
				}
				// 回复原状
				x[t]=0;
			}
		}
	}
	
	private static boolean ok(int k){
		// 检查颜色可用性
		// 相邻不能是相同的颜色
		for (int j=0;j<n;j++){
			if(a[k][j]==1 && (x[j]==x[k])){
				return false;
			}
		}
		return true;
	}
}
