import java.util.*;

public class Queue<T> {
	private T[] elements;
	private int front,end; 
	private final int DEFAULT_SIZE = 30000;
	private int _size;
	@SuppressWarnings("unchecked")
	public Queue(){
		_size = DEFAULT_SIZE;
		elements = (T[]) new Object[_size];
		front = end = 0;
	}
	@SuppressWarnings("unchecked")
	public Queue(int n){
		_size = n;
		elements = (T[]) new Object[_size];
		front = end = 0;		
	}
	public void clear(){
		front = end = 0;
	}
	public boolean full(){
		return (end + 1)%_size==front;
	}
	public boolean empty(){
		return front==end;
	}
	public boolean push(T a){
		if(full()){
//			System.out.println(front+" "+end);
			return false;
		}
		end = (end + 1)%_size;
		elements[end] = a;
		return true;
	}
	public T pop(){
		if(empty()) 
			throw new NoSuchElementException();
		front = (front + 1)%_size;
		return elements[front];
	}
	public T front(){
		return elements[(front + 1)%_size];
	}
}
