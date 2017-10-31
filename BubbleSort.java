
public class BubbleSort {
	static int[] a;
	public static void Sort1(int n){
		boolean sort = false;
		while(!sort){
			sort = true;
			for(int i=1;i<n;++i){
				if(a[i]<a[i-1]){
					sort = false;
					int mid = a[i];
					a[i] = a[i-1];
					a[i-1] = mid;
				}
			}
			--n;
		}
	}
	public static void main(String[] args){
		a = new int[]{5,4,3,2,1};
		for(int i=0;i<5;++i){
			System.out.print(a[i]);
			System.out.print(' ');
		}
		System.out.println();
		Sort1(5);
		for(int i=0;i<5;++i){
			System.out.print(a[i]);
			System.out.print(' ');
		}
		a = new int[]{5,4,3,2,1};
	}
}
