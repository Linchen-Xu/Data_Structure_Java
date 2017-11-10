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
	public static void main(String [] args){
		BinSearchTree<Integer> test = new BinSearchTree<Integer>();
		test.insert(Integer.valueOf(8));
		test.insert(Integer.valueOf(4));
		test.insert(Integer.valueOf(10));
		test.insert(Integer.valueOf(6));
		test.insert(Integer.valueOf(12));
		System.out.println(test.findmax());
		test.remove(4);
		System.out.println(test.findmin());
		test.root().setlchild(null);
		System.out.println(test.findmin());
		System.out.println(" " + test.findmax());
		test.remove(8);
		System.out.println(test.findmin());
		System.out.println(test.findmax());
		test.remove(12);
		System.out.println(" " + test.findmin());
		System.out.println(test.findmax());
		test.root().setrchild(null);
		System.out.println(test.findmax());
	}
}
