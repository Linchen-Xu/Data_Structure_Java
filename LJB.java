import java.util.HashMap;


public class LJB {
	
	private HashMap<String,Integer> mp;
	private HashMap<Integer,String> mp1;
	private final int inf = 10000000;
	private Queue<Integer> q;
	private boolean[] vis;
	private int[] d;
	private int[][] fee;
	
	private class Node{
		public int next, to, w;
		public Node(){
			next = to = -1;
			w = 0;
		}
	}
	private Node[] edge;	//¡¥ Ω«∞œÚ–«
	private int[] head;
	private int[] pre;
	private int total;
	private int cnt, mpcnt;
	
	
	public LJB(){
		cnt=mpcnt=0;
		mp = new HashMap<String,Integer>();
		mp1 = new HashMap<Integer,String>();
		edge = new Node[55];
		head = new int[22];
		fee = new int[22][22];
		for(int i=0;i<22;++i)
			for(int j=0;j<22;++j)
				fee[i][j]=0;
		for(int i=0;i<22;++i)
			head[i]=-1;
		total = 0;
	}
	
	public boolean empty(){
		return mpcnt == 0;
	}
	
	public void add(int u,int v,int w){
//		System.out.println(u);
//		System.out.println(v);
//		System.out.println(w);
		edge[cnt] = new Node();
		edge[cnt].to = v;
		edge[cnt].w = w;
		edge[cnt].next = head[u];
		head[u] = cnt++;
	}
	
	public void spfa(int from,int to){
		vis = new boolean[mpcnt];
		d = new int[mpcnt];
		pre = new int[mpcnt];
		for(int i=0;i<mpcnt;++i){
			d[i] = inf;
			pre[i] = -1;
			vis[i] = false;
		}
		d[from] = 0;
		q = new Queue<Integer>();
		q.push(from);
		vis[from] = true;
		while(!q.empty()){
			int v = q.front();
			q.pop();
			vis[v] = false;
			for(int ie = head[v]; ie != -1; ie = edge[ie].next){
//				System.out.println("test");
				Node e = edge[ie];
				if(d[e.to]>d[v]+e.w){
					d[e.to] = d[v] + e.w;
					pre[e.to] = v;
					if(false == vis[e.to]){
						vis[e.to] = true;
						q.push(e.to);
					}
				}
			}
		}
	}
	
	public String printpath(int from,int t){
		Stack<Integer> S = new Stack<Integer>(30);
		String ans = "";
		int p = t;
		S.push(t);
		while(true){
			p = pre[p];
			if(p == -1) break;
			S.push(p);
		}
		S.push(from);
		while(!S.empty()){
			p = S.pop();
			ans += mp1.get(p);
			if(!S.empty()){
				ans += " to ";
				total += fee[p][S.top()];
			}
		}
		return ans;
	}
	
	
}
