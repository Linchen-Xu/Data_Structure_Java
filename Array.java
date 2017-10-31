
public class Array<Type> {
	private static final int DEFAULT_CAPACITY = 10;
	private Type[] elements;
	private int _size;
	@SuppressWarnings("unchecked")
	public Array(){
		elements = (Type[])new Object[DEFAULT_CAPACITY];
		_size = 0;
	}
	@SuppressWarnings("unchecked")
	public Array(int sz){
		elements = (Type[])new Object[sz];
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
		elements = (Type[])new Object[newSize];
		for(int i=0;i<_size;++i)
			elements[i] = old[i];
		return;
	}
	public Type get(int index){
		return elements[index];
	}
	public void trimToSize(){
		ensureCapacity(_size);
	}
	public void set(int index,Type a){
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
	public boolean add(Type a){
		set(_size,a);
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
		for(int i=0;i<_size;++i){
			//System.out.println(i + ' ' + elements[i].toString());
			if(elements[i].equals(a)){
				remove(i);
				return true;
			}
		}
		return false;
	}
	public int find(Type a){
		for(int i=0;i<_size;++i)
			if(elements[i].equals(a))
				return i;
		return -1;
	}
//	public static void main(String []args){
//		Array<Double> seq = new Array<Double>();
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
//		seq.add(3.0);
//		System.out.println(seq.find(3.0));
//	}
}
