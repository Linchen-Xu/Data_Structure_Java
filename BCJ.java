
public class BCJ {
	int[] par,w;
	public BCJ(int n){
		par = new int[n+5];
		w = new int[n+5];
		init(n);
	}
	private void init(int n){
		for(int i=1;i<=n;++i){
			par[i]=i;
			w[i]=0;
		}
	}
	public void union(int x,int y){
		x = fnd(x);
		y = fnd(y);
		if(x==y) return;
		if(w[x]>w[y]) par[y] = par[x];
		else{
			par[x] = y;
			if(w[x]==w[y]) ++w[x];
		}
	}
	public int fnd(int x){
		if(par[x]==x) return x;
		return par[x] = fnd(par[x]);
	}
	boolean comp(int x,int y){
		return fnd(x) == fnd(y);
	}
}
