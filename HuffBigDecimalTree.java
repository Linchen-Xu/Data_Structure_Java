import java.math.BigDecimal;

public class HuffBigDecimalTree{
	private class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
		public T data;			//compareTo: greater one with greater priority
		@SuppressWarnings("unused")
		public Node<T> lchild, rchild;
		public Node(T a){
			data = a;
			lchild = null;
			rchild = null;
		}
		public Node(T a,Node<T> l,Node<T> r){
			data = a;
			lchild = l;
			rchild = r;
		}
		public int compareTo(Node<T> a) {	//greater one with less priority
			int res = data.compareTo(a.data);
			if(res < 0) return 1;
			else if(res == 0) return 0;
			else return -1;
		}
		public String toString(){
			return data.toString();
		}
	}
	
	private PQueue<Node<BigDecimal>> pq;
	private Node<BigDecimal> data, data1;
	
	public HuffBigDecimalTree(){
		pq = new PQueue<Node<BigDecimal>>();
	}
	
	public void add(BigDecimal a){
		data = new Node<BigDecimal>(a);
		pq.insert(data);
		return;
	}
	
	public void Prim(){
		while(pq.size() > 1){
			data = pq.delete();
			data1 = pq.delete();
			pq.insert(new Node<BigDecimal>(data.data.add(data1.data),data,data1));
		}
		return;
	}
	
	public int size(){
		return pq.size();
	}
	
	public String toString(){
		return pq.top().toString();
	}
}
