
public class AdjacencyList {
	private class Node{
		@SuppressWarnings("unused")
		public int to, w, next;
	}
	private Node[] mp;
	private int[] head;
	private final int DEFAULT_SIZE = 10;
	private int cnt , _size; // num of edges
	
	public AdjacencyList(){
		_size = DEFAULT_SIZE;
		mp = (Node[]) new Object[_size];
		cnt = 0;
		head = new int[_size];
		for(int i=0; i<_size ;++i)
			head[i] = -1;
	}
	public AdjacencyList(int n){
		_size = n;
		mp = (Node[]) new Object[_size];
		cnt = 0;
		head = new int[_size];
		for(int i=0; i<_size ;++i)
			head[i] = -1;
	}
	public boolean add(int u,int v,int w){
		if(cnt == _size-1) return false;
		mp[cnt].to = v;
		mp[cnt].w = w;
		mp[cnt].next = head[u];
		head[u] = cnt++;
		return true;
	}
}
