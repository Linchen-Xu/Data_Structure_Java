

public class Polynomial {
	private class Term implements Comparable<Term>{
		public float coef;
		public int exp;
		public Term(float a,int b){
			coef = a;
			exp = b;
		}
		public int compareTo(Term e) {
			if(exp == e.exp){
				if(coef == e.coef) return 0;
				if(coef < e.coef) return -1;
				return 1;
			}
			if(exp < e.exp) return -1;
			return 1;
		}
	}
	private final int DEFAULT_CAPACITY = 10;
	private int degree;
	private OrderedSeqList<Term> coef;	//需要改成有序顺序表
	public Polynomial(){
		coef = new OrderedSeqList<Term>(DEFAULT_CAPACITY+1);
		degree = DEFAULT_CAPACITY;
	}
	public Polynomial(int newdegree){
		coef = new OrderedSeqList<Term>(newdegree+1);
		degree = newdegree;
	}
	public void add(Polynomial B){
		Polynomial c = new Polynomial(max(coef.size() , B.size())) , 
				   mid1, mid2;
		if(this.size() < B.size()){
			mid1 = B;
			mid2 = this;
		}else{
			mid1 = this;
			mid2 = B;
		}
		// not done
	}
	public void addterm(float co,int exp){
		coef.add(new Term(co,exp));
		degree = max(degree , exp);
	}
	private int max(int a,int b){
		if(a >=b) return a;
		else return b;
	}
	public int size(){
		return coef.size();
	}
}
