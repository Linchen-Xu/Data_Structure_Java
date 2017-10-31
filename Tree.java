
public class Tree<T> {
	private final int DEFAULT_SIZE = 10;
	private int _size, currentsize;
	private Array<T> list;
	public Tree(){
		_size = DEFAULT_SIZE; 
		list = new Array<T>(_size);
		currentsize = 0;
	}
	public Tree(int n){
		_size = n; 
		list = new Array<T>(_size);
		currentsize = 0;
	}
	/*
	 * ...
	 */
}
