public class LinkedList<T> {
	private static class node<T>{
		private T data;
		private node<T> next;
		public node(){
			data = null;
			next = null;
		}
		public node(T a){
			data = a;
			next = null;
		}
		public node<T> nextnode(){
			return this.next;
		}
		public T getdata(){
			return this.data;
		}
	}
	node<T> head;
	int _size;
	LinkedList(){
		head = new node<T>();
		_size = 0;
	}
	public void insert(T a){
		this.insert(a,_size);
	}
	public int size(){
		return _size;
	}
	private node<T> getelement(int i){
		if(i<-1) return null;
		if(i==-1) return head;
		node<T> data = head;
		int j = i;
		while(j-- >= 0) 
			data = data.nextnode();
		return data;
	}
	public T get(int i){
		return this.getelement(i).data;
	}
	public int find(T a){
		int i = 0;
		node<T> mid = head.nextnode();
		while(mid != null && !mid.getdata().equals(a)){
			mid = mid.nextnode();
			++i;
		}
		return i;
	}
	public void insert(T a,int i){
		if(i < 0 || i > this.size())
			throw new java.util.NoSuchElementException();
		node<T> data = head;
		node<T> newdata = new node<T>(a);
		int j = i;
		while(j-- > 0)
			data = data.nextnode();
		newdata.next = data.nextnode();
		data.next = newdata;
		++_size;
		return;
	}
	public T remove(int i){
		if(i < 0 || i > this.size())
			throw new java.util.NoSuchElementException();
		node<T> data = head;
		int j = i;
		while(j-- > 0)
			data = data.nextnode();
		node<T> mid = data;
		data = data.nextnode();
		mid.next = mid.next.nextnode();
		--_size;
		return data.getdata();
	}
	public void add(T a,int i){
		this.insert(a,i);
	}
	public void delete(int i){
		this.remove(i);
	}
//	public static void main(String[] args){
//		LinkedList<String> lis = new LinkedList<String>();
//		lis.insert("A");
//		lis.insert("B");
//		lis.insert("C");
//		lis.insert("D");
//		System.out.println(lis.get(0));
//		System.out.println(lis.get(1));
//		System.out.println(lis.get(2));
//		lis.remove(1);
//		System.out.println(lis.get(1));
//		lis.remove(0);
//		System.out.println(lis.get(1));
//		lis.remove(1);
//		System.out.println(lis.get(0));
//	}
}
