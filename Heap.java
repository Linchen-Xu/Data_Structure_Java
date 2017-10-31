/*
 * location of top element: 1
 * location 0 used to process data
 */
public class Heap<T extends Comparable<T>>{
	private final int DEFAULT_SIZE = 10;
	private T[] elements;
	private int _size;
	private int currentsize;
	@SuppressWarnings("unchecked")
	public Heap(){
		_size = DEFAULT_SIZE;
		elements = (T[])new Comparable[_size];
		currentsize = 0;
	}
	@SuppressWarnings("unchecked")
	public Heap(int n){
		_size = n;
		elements = (T[])new Comparable[_size];
		currentsize = 0;
	}
	@SuppressWarnings("unchecked")
	public Heap(T[] list){
		_size = list.length+1;
//		System.out.println(_size);
		elements = (T[]) new Comparable[_size];
		for(int i=1;i<_size;++i)
			elements[i] = list[i-1];
		int i=1,j,k;
		while(i*2 < _size&&!elements[i*2].equals(null)) 
			i*=2;
		for(currentsize = i;currentsize < _size && elements[currentsize].toString() != null;++currentsize){
//			System.out.println(currentsize + " " + elements[currentsize].toString());
		}
//		System.out.println("currentsize :"+currentsize);
//		System.out.println();
		boolean sorted = false;
//		int cnt=0;
		while(!sorted){
			sorted = true;
			j=i;k=currentsize;
			while(j>1){
				for(int l = j;l < k;++l)
					if(elements[l].compareTo(elements[l/2])>0){
						swap(l,l/2);
						sorted = false;
					}
				k=j-1;
				j/=2;
			}
//			System.out.println("time of sort:" + ++cnt);
		}
		--currentsize;
	}
	public int size(){
		return _size;
	}
	public int numofelements(){
		return currentsize;
	}
	public boolean empty(){
		return currentsize==0;
	}
	public boolean full(){
		return currentsize+1==_size;
	}
	@SuppressWarnings("unchecked")
	private void expandcapacity(int n){
		T[] old = elements;
		elements = (T[])new Comparable[n];
		for(int i=1;i<=currentsize;++i)
			elements[i] = old[i];
		_size = n;
	}
	public void insert(T data){
		if(full())
			return;
		/*
		 * resize
		 */
		if(currentsize + 1 == _size)
			expandcapacity(_size*2+1);
		/*
		 * filter up
		 */
		int location = ++currentsize;
		for(elements[0]=data;data.compareTo(elements[location/2])>0;location/=2)
			elements[location] = elements[location/2];
		elements[location] = data;
	}
	public T top(){
		if(empty())
			return null;
		return elements[1];
	}
	public T delete(){
		if(empty())
			return null;	
		int location = 1;
		T data = elements[1];
		elements[location] = elements[currentsize];
		/*
		 * filter down
		 */
		while(location*2 < currentsize&&
				(elements[location].compareTo(elements[location*2])<0||
						elements[location].compareTo(elements[location*2+1])<0)){
			if(elements[location*2].compareTo(elements[location*2+1])<0){
				elements[location] = elements[location*2+1];
				location = location*2+1;
			}else{
				elements[location] = elements[location*2];
				location = location*2;
			}
		}
		elements[location] = elements[currentsize--];
		return data;
	}
	/*
	 *relevant function 
	 */
	
	private void swap(int a,int b){
		T c = elements[a];
		elements[a] = elements[b];
		elements[b] = c;
		return;
	}
}
