//class Inte implements Comparable<Inte>{
//	public int i;
//	public Inte(int x){
//		i = x;
//	}
//	public int compareTo(Inte o) {
//		if(i == o.i) return 0;
//		else if(i > o.i) return 1;
//		else return -1;
//	}
//	
//}

public class OrderedSeqList<Type extends Comparable<Type>>{
	private static final int DEFAULT_CAPACITY = 10;
	private Type[] elements;
	private int _size;
	@SuppressWarnings("unchecked")
	public OrderedSeqList(){
		elements = (Type[])new Comparable[DEFAULT_CAPACITY];
		_size = 0;
	}
	@SuppressWarnings("unchecked")
	public OrderedSeqList(int sz){
		elements = (Type[])new Comparable[sz];
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
		Type[] old = elements;
		elements = (Type[])new Comparable[newSize];
		for(int i=0;i<_size;++i)
			elements[i] = old[i];
		return;
	}
	public void trimToSize(){
		ensureCapacity(_size);
	}
	private int lower_bound(Type a){
		int l = 0 , len = _size , mid, half;
		//System.out.println("size = "+_size);
		while(len > 0){
			half = len/2;
			mid = l + half;
			if(elements[mid].compareTo(a) == -1){
				l = mid + 1;
				len = len - half - 1;
			}else len = half;
			//System.out.println("l = "+l+", len = "+len+" mid = "+mid+"half = "+half);
		}
		return l;
	}
	@SuppressWarnings("unused")
	private int upper_bound(Type a){
		int l = 0 , len = _size , mid, half;
		while(len > 0){
			half = len >> 1;
			mid = l + half;
			if(elements[mid].compareTo(a) <= 0){
				l = mid + 1;
				len = len - half - 1;
			}else len = half;
		}
		return l;
	}
	public boolean add(Type a){
		int index = lower_bound(a);
		if(index < 0 || index > _size)
			throw new ArrayIndexOutOfBoundsException();
		if(index == elements.length) 
			ensureCapacity(_size*2+1);
		for(int i=_size;i>index;--i)
			elements[i]=elements[i-1];
		++_size;
		elements[index]=a;
		return true;
	}
	private Type remove(int index){
		if(index < 0 || index >= _size)
			throw new ArrayIndexOutOfBoundsException();
		Type removed = elements[index];
		for(int i=index;i<_size;++i)
			elements[i] = elements[i+1];
		--_size;
		return removed;
	}
	public boolean remove(Type a){
		int index = lower_bound(a);
		if(index < 0 || index >= _size || !elements[index].equals(a)) return false;
		remove(index);
		return true;
	}
	public Type getbyindex(int i){
		return elements[i];
	}
	public int find(Type a){
		return lower_bound(a);
	}
	
//	public static void main(String []args){
//		OrderedSeqList<Inte> seq = new OrderedSeqList<Inte>();
//		Inte mid = new Inte(1);
//		seq.add(mid);
//		mid = new Inte(5);
//		seq.add(mid);
//		mid = new Inte(3);
//		seq.add(mid);
//		System.out.println(mid.i + " " + seq.find(mid));
//		mid = new Inte(5);
//		System.out.println(mid.i + " " + seq.find(mid));	
//		mid = new Inte(3);	
//		seq.remove(mid);
//		System.out.println("3 removed");
//		mid = new Inte(2);
//		seq.add(mid);
//		mid = new Inte(4);
//		seq.add(mid);
//		mid = new Inte(1);
//		System.out.println(mid.i + " " + seq.find(mid));
//		mid = new Inte(2);
//		System.out.println(mid.i + " " + seq.find(mid));
//		mid = new Inte(3);
//		System.out.println(mid.i + " " + seq.find(mid));
//		mid = new Inte(4);
//		System.out.println(mid.i + " " + seq.find(mid));
//		mid = new Inte(5);
//		System.out.println(mid.i + " " + seq.find(mid));
//	}
	
}
