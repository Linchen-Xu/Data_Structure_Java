import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * 
 * @author xlc
 * 
 * @param <T>
 * 
 * @version BinTree
 * 
 */

class Binode<T>{
	private T data;
	private Binode<T> lchild, rchild, parent;
	public Binode(){
		data = null;
		lchild = null;
		rchild = null;
		parent = null;
	}
	public Binode(T a){
		data = a;
		lchild = null;
		rchild = null;
		parent = null;
	}
	public Binode(T a,Binode<T> lc,Binode<T> rc){
		data = a;
		lchild = lc;
		rchild = rc;
		parent = null;
	}
	public Binode(T a,Binode<T> lc,Binode<T> rc,Binode<T> par){
		data = a;
		lchild = lc;
		rchild = rc;
		parent = par;
	}
	/*
	 * data
	 */
	public T getdata(){
		return data == null ? null : data;
	}
	public void setdata(T a){
		data = a;
	}
	
	/*
	 * lc
	 */
	public Binode<T> getlchild(){
		return lchild == null ? null : lchild;
	}
	public void setlchild(Binode<T> a){
		lchild = a;
	}
	/*
	 * rc
	 */
	public Binode<T> getrchild(){
		return rchild == null ? null : rchild;
	}
	public void setrchild(Binode<T> a){
		rchild = a;
	}
	/*
	 * parent
	 */
	public void setparent(Binode<T> a){
		parent = a;
	}
	public Binode<T> getparent(){
		return parent == null ? null : parent;
	}
}

abstract class TreeIterator<T> extends Iterator{
	private Binode<T> root;
	/*
	 * not finished
	 */
}

public class BinTree<T extends Comparable<T>>{
	private Binode<T> _root, node;
	
	public BinTree(){
		_root = null;
	}
	public boolean empty(){
		return null == _root;
	}
	public int size(){
		return size(_root);
	}
	private int size(Binode<T> current){
		if(current == null)return 0;
		else return 1+
					size(current.getlchild())+
					size(current.getrchild());
	}
	public int height(){
		return height(_root);
	}
	private int height(Binode<T> current){
		if(current == null) return -1;
		else return 1 + max(height(current.getlchild()),height(current.getrchild()));
	}
	
	/*
	 * node
	 */
	public Binode<T> parent(Binode<T> a){
		return a.getparent();
	}
	public Binode<T> root(){
		return _root;
	}
	public Binode<T> lchild(Binode<T> current){
		return current.getlchild();
	}
	public Binode<T> rchild(Binode<T> current){
		return current.getrchild();
	}

	public void insert(T item){
		if(root() == null){
			_root = new Binode<T>(item);
			_root.setparent(null);
			return;
		}
		insert(item,_root);
	}
	private void insert(T item,Binode<T> current){
		if(current.getdata() == null){
			current.setdata(item);
//			System.out.println(current.getdata());
			return;
		}
		node = new Binode<T>();
		if(item.compareTo(current.getdata()) <= 0){
			if(current.getlchild() == null){
				current.setlchild(node);
				node.setparent(current);
			}
			insert(item,current.getlchild());
		}else{
			if(current.getrchild() == null){
				current.setrchild(node);
				node.setparent(current);
			}
			insert(item,current.getrchild());
		}
	}
	
	/*
	 * not finished
	 */
	public void remove(T item){
		System.out.println("not finished");
		return;
//		Binode<T> removenode = find(item);
//		if(removenode != null){
//			if(removenode.equals(removenode.getparent().getlchild()))
//				removenode.getparent().setlchild(null);
//			else 
//				removenode.getparent().setrchild(null);
//		}
	}
	/*
	 * not finished
	 */
	
	public Binode<T> find(T item){
		return find(item,_root);
	}
	private Binode<T> find(T item,Binode<T> current){
		if(current == null) return null;
		switch(item.compareTo(current.getdata())){
			case -1:return find(item,current.getlchild());
			case 0:return current;
			default: return find(item,current.getrchild());
		}
	}
	
	/*
	 * preorder
	 */
	
	public void preorder(){
		preorder(_root);
		System.out.println();
	}
	
	public void preorder(Binode<T> current){
		if(current == null) return;
		System.out.print(current.getdata().toString()+" ");
		preorder(current.getlchild());
		preorder(current.getrchild());
	}
	
	/*
	 * inorder
	 */
	
	public void inorder(){
		inorder(_root);
		System.out.println();
	}
	public void inorder(Binode<T> current){
		if(current == null)return;
		inorder(current.getlchild());
		System.out.print(current.getdata().toString()+" ");
		inorder(current.getrchild());
	}

	/*
	 * postorder
	 */
	
	public void postorder(){
		postorder(_root);
		System.out.println();
	}
	public void postorder(Binode<T> current){
		if(current == null)return;
		postorder(current.getlchild());
		postorder(current.getrchild());
		System.out.print(current.getdata().toString()+" ");
	}
	
	/*
	 * non-recursive implementation
	 */
	
	public void nonrecpre(){
		Stack<Binode<T>> S = new Stack<Binode<T>>();
		Binode<T> mid = _root;
		do{
			while(mid != null){
				System.out.print(mid.getdata().toString()+" ");
				S.push(mid.getrchild());
				mid = mid.getlchild();
			}
			mid = S.pop();
		}while(mid != null || !S.empty());
		System.out.println();
		return;
	}

	public void nonrecin(){
		Stack<Binode<T>> S = new Stack<Binode<T>>();
		Binode<T> mid = _root;
//		int count = 0;
		do{
			while(mid != null){
				S.push(mid);
				mid = mid.getlchild();
			}
			if(!S.empty()){
				mid = S.pop();
				System.out.print(mid.getdata().toString() + " ");
				mid = mid.getrchild();
			}
		}while(mid != null || !S.empty());
		System.out.println();
		return;
	}
	
	/*
	 * not finished
	 */
	
//	public void nonrecpost(){
//		Stack<Binode<T>> S = new Stack<Binode<T>>();
//		Binode<T> mid = _root;
//		System.out.println("not done");
//		System.out.println();
//		return;
//	}
	
	
	
	/*
	 * relevant function
	 */
	private int max(int a,int b){
		return a>b?a:b;
	}
	
}
