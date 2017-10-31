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
		PQueue<Node> test = new PQueue<Node>();
		System.out.println("size: "+ test.size());
//		/*
//		 * insert
//		 */
//		Node data = new Node(57);
//		test.insert(data);
//		System.out.println(test.top().toString());
//		data = new Node(17);
//		test.insert(data);
//		System.out.println(test.top().toString());
//		data = new Node(78);
//		test.insert(data);
//		System.out.println(test.top().toString());
//		data = new Node(9);
//		test.insert(data);
//		System.out.println(test.top().toString());
//		data = new Node(45);
//		test.insert(data);
//		System.out.println(test.top().toString());
//		data = new Node(65);
//		test.insert(data);
//		System.out.println(test.top().toString());
//		data = new Node(87);
//		test.insert(data);
//		System.out.println(test.top().toString());
//		/*
//		 * delete
//		 */
//		test.delete();
//		System.out.println(test.top().toString());
//		test.delete();
//		System.out.println(test.top().toString());
//		test.delete();
//		System.out.println(test.top().toString());
//		test.delete();
//		System.out.println(test.top().toString());
//		test.delete();
//		System.out.println(test.top().toString());
//		test.delete();
//		System.out.println(test.top().toString());
//		test.delete();
//		System.out.println(test.empty());
//		
		System.out.println(11111111);
		
		Node[] list = new Node[7];
		list[0] = new Node(57);
		list[1] = new Node(17);
		list[2] = new Node(78);
		list[3] = new Node(9);
		list[4] = new Node(45);
		list[5] = new Node(65);
		list[6] = new Node(87);
		test = new PQueue<Node>(list);
		/*
		 * delete
		 */
		System.out.println("size: "+ test.size());
		System.out.println(" " + test.numofelements());
		test.delete();
		System.out.println(test.top().toString());
		System.out.println(" " + test.numofelements());
		test.delete();
		System.out.println(test.top().toString());
		System.out.println(" " + test.numofelements());
		test.delete();
		System.out.println(" " + test.numofelements());
		System.out.println(test.top().toString());
		test.delete();
		System.out.println(" " + test.numofelements());
		System.out.println(test.top().toString());
		test.delete();
		System.out.println(" " + test.numofelements());
		System.out.println(test.top().toString());
		test.delete();
		System.out.println(" " + test.numofelements());
		System.out.println(test.top().toString());
		test.delete();
		System.out.println(test.empty());
		
	}
}
