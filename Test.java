import java.util.Scanner;
import java.math.*;

class Node implements Comparable<Node>{
	public Integer i = null;
	public Node(int n){
		i=n;
	}
	public int compareTo(Node b) {
		return i.compareTo(b.i);
	}
	public String toString(){
		return i.toString(); 
	}
}

public class Test {
	static int t;
	static int n;
	static Scanner cin;
	public static void main(String [] args){
		
	}
}
