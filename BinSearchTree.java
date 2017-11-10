/**
 * 
 * @author xlc
 * 
 * @param <T>
 * 
 * @version BinSearchTree
 * 
 * @category contains functions to traverse the tree
 * 
 */

class Binode<T extends Comparable<T>> implements Comparable<Binode<T>>{
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
		return lchild;
	}
	public void setlchild(Binode<T> a){
		lchild = a;
	}
	public boolean haslchild(){
		return lchild != null;
	}
	public void clearlchild(){
		lchild = null;
	}
	/*
	 * rc
	 */
	public Binode<T> getrchild(){
		return rchild;
	}
	public void setrchild(Binode<T> a){
		rchild = a;
	}
	public boolean hasrchild(){
		return rchild != null;
	}
	public void clearrchild(){
		rchild = null;
	}
	/*
	 * parent
	 */
	public void setparent(Binode<T> a){
		parent = a;
	}
	public Binode<T> getparent(){
		return parent;
	}
	public boolean hasparent(){
		return parent != null;
	}
	public void clearparent(){
		parent = null;
	}
	public String toString(){
		return data.toString();
	}
	public int compareTo(Binode<T> a) {
		return data.compareTo(a.getdata());
	}
}

public class BinSearchTree<T extends Comparable<T>>{
	private Binode<T> _root;
	
	public BinSearchTree(){
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
		Binode<T> node = new Binode<T>(item);
		insert(node,_root);
	}
	private void insert(Binode<T> node,Binode<T> current){
//		System.out.println(current.getdata().toString());
//		System.out.println(item.getdata().toString());
		int res = node.getdata().compareTo(current.getdata()); 
		if(res < 0){
			if(!current.haslchild()){
				current.setlchild(node);
				node.setparent(current);
			}
			insert(node,current.getlchild());
		}else if (res > 0){
			if(!current.hasrchild()){
				current.setrchild(node);
				node.setparent(current);
			}
			insert(node,current.getrchild());
		}
	}
	
	/*
	 * not finished
	 */
	public void remove(T item){
		remove(item,_root);
	}
	
	private void remove(T x,Binode<T> r){
		if(r == null) return;
		int res = r.getdata().compareTo(x);
		if(res<0) remove(x,r.getlchild());
		else if(res>0) remove(x,r.getrchild());
			 else{ 
				 if(r.haslchild() && r.hasrchild()){
					 r.setdata(findmin(r.getrchild()).getdata());
					 remove(r.getdata(),r.getrchild());
				 }else{	//r has at most 1 child
					 if(r.hasparent()){
						 Binode<T> mid = r.getparent();
						 if(mid.haslchild() && mid.getlchild().equals(r)){
							 if(r.haslchild()) mid.setlchild(r.getlchild());
							 else if(r.hasrchild()) mid.setlchild(r.getrchild());
							 else mid.clearlchild();
						 }else{
							 if(r.haslchild()) mid.setrchild(r.getlchild());
							 else if(r.hasrchild()) mid.setrchild(r.getrchild());
							 else mid.clearrchild();
						 }
					 }else
						 _root = _root.haslchild() ? _root.getlchild() : (_root.hasrchild() ? _root.getrchild() : null);
				 }
			 }
	}
	/*
	 * not finished
	 */
	
	public Binode<T> find(T item){
		return find(item,_root);
	}
	private Binode<T> find(T item,Binode<T> current){
		if(current == null) return null;
		int res = item.compareTo(current.getdata());
		if(res < 0) return find(item,current.getlchild());
		if(res > 0) return find(item,current.getrchild());
		return current;
	}
	
	public T findmin(){
		return findmin(_root).getdata();
	}
	
	private Binode<T> findmin(Binode<T> a){
		Binode<T> b = a;
		while(b.haslchild())
			b = b.getlchild();
		return b;
	}
	
	public T findmax(){
		return findmax(_root).getdata();
	}
	
	private Binode<T> findmax(Binode<T> a){
		Binode<T> b = a;
		while(b.hasrchild())
			b = b.getrchild();
		return b;
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
