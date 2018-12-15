package experiment.five;

/**
 * 活动安排问题
 * @author LNW
 */
public class GreedySelector {
	public static void main(String[] args) {
		int[] s = {1,3,0,5,3,5,6,8,8,2,12};
		int[] f = {4,5,6,7,8,9,10,11,12,13,14};
		boolean[] a = new boolean[s.length];
		System.out.println("可安排活动总数："+greedySelector(s,f,a));
		System.out.println("活动为：");
		for (int i = 0; i < a.length; i++) {
			if (a[i]){
				System.out.print("活动"+(i+1)+"  ");
			}

		}
	}
	public static int greedySelector(int[] s,int[] f,boolean[] a){
		int n = s.length;
		a[0] = true;
		int j=0;
		int count = 1;
		for(int i=1;i<n;i++){
			if(s[i]>=f[j]){
				a[i] = true;
				j=i;
				count++;
			}
			else{
				a[i]=false;
			}
		}
		return count;
	}
	
}
