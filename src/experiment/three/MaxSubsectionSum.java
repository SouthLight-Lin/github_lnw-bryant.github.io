package experiment.three;

/**
 * 计算子段和的最大值
 *
 */
public class MaxSubsectionSum {
	public static void main(String[] args) {
		int[] a = {-2,11,-4,13,-5,-2};
		System.out.println(MaxSum(a.length, a));
	}
	
	public static int MaxSum(int n,int[] a){
		int sum=0,b=0;
		for(int i=0;i<n;i++){
			if(b>0)
				b+=a[i];
			else
				b=a[i];
			if(b>sum)
				sum=b;
		}
		return sum;
		
	}
}
