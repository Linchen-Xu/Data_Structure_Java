
public class PQueue<Type extends Comparable<Type>> extends Heap<Type>{
	public PQueue(){
		super();
	}
	public PQueue(int n){
		super(n);
	}
	public PQueue(Type[] list){
		super(list);
	}
}
