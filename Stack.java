
public class Stack<T> {
	private int _size = -1;
	private final int maxsize = 30000;
	private int currentsize;
	private T[] elements;
	private int DEFAULT_SIZE = 10;
	@SuppressWarnings("unchecked")
	public Stack(){
		elements =(T[])new Object[DEFAULT_SIZE];
		currentsize = DEFAULT_SIZE;
	}
	@SuppressWarnings("unchecked")
	public Stack(int n){
		elements =(T[])new Object[n];
		currentsize = n;
	}
	@SuppressWarnings("unchecked")
	private boolean EnsureCapaticy(int n){
		if(n > maxsize) return false;
		if(n > currentsize){
			T[] old = elements;
			elements =(T[]) new Object[min(n*2+1,maxsize)];
			for(int i=0;i<=currentsize;++i)
				elements[i] = old[i];
			currentsize = min(n*2+1,maxsize);
		}
		return true;
	}
	@SuppressWarnings("unused")
	private int max(int a,int b){
		if(a > b) return a;
		else return b;
	}
	private int min(int a,int b){
		if(a < b) return a;
		else return b;
	}
	public boolean push(T a){
		if(!EnsureCapaticy(_size+1)) return false;
		elements[++_size] = a;
		return true;
	}
	public boolean empty(){
		return _size==-1;
	}
	public T top(){
		return elements[_size];
	}
	public T pop(){
		if(empty()) return null;
		return elements[_size--];
	}
	public boolean full(){
		return _size==maxsize-1;
	}
	public int size(){
		return currentsize;
	}
}
