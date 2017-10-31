
public class SeqList<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private T[] elements;
	private int _size;
	@SuppressWarnings("unchecked")
	public SeqList(){
		elements = (T[])new Object[DEFAULT_CAPACITY];
		_size = 0;
	}
	@SuppressWarnings("unchecked")
	public SeqList(int sz){
		elements = (T[])new Object[sz];
		_size = 0;
	}
	public int size(){
		return _size;
	}
	public void clear(){
		_size = 0;
		return;
	}
	public boolean isEmpty(){
		return _size == 0;
	}
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int newSize){
		if(newSize < _size ) return;
		T[] old = elements;
		elements = (T[])new Object[newSize];
		for(int i=0;i<_size;++i)
			elements[i] = old[i];
		return;
	}
	public void trimToSize(){
		ensureCapacity(_size);
	}
	public void add(int index,T a){
		if(index < 0 || index > _size)
			throw new ArrayIndexOutOfBoundsException();
		if(index == elements.length) 
			ensureCapacity(_size*2+1);
		for(int i=_size;i>index;--i)
			elements[i]=elements[i-1];
		++_size;
		elements[index]=a;
		return;
	}
	public boolean add(T a){
		add(_size,a);
		return true;
	}
	private T remove(int index){
		if(index < 0 || index >= _size)
			throw new ArrayIndexOutOfBoundsException();
		T removed = elements[index];
		for(int i=index;i<_size;++i)
			elements[i] = elements[i+1];
		--_size;
		return removed;
	}
	public boolean remove(T a){
		for(int i=0;i<_size;++i){
			//System.out.println(i + ' ' + elements[i].toString());
			if(elements[i].equals(a)){
				remove(i);
				return true;
			}
		}
		return false;
	}
	public int find(T a){
		for(int i=0;i<_size;++i)
			if(elements[i].equals(a))
				return i;
		return -1;
	}
	public T get(int i){
		return elements[i];
	}
//	public static void main(String []args){
//		SeqList<Double> seq = new SeqList<Double>();
//		seq.add(1.0);
//		seq.add(2.0);
//		seq.add(3.0);
//		seq.add(4.0);
//		seq.add(5.0);
//		System.out.println(seq.find(3.0));
//		seq.remove(3.0);
//		System.out.println(seq.find(1.0));
//		System.out.println(seq.find(2.0));
//		System.out.println(seq.find(3.0));
//		System.out.println(seq.find(4.0));
//		System.out.println(seq.find(5.0));
//		seq.add(1,3.0);
//		System.out.println(seq.find(3.0));
//	}
}
