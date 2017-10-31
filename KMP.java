
public class KMP {
	private int[] next;
	private int size;
	private char[] s;
	public KMP(int n,char[] s1){
		next = new int[n];
		size = n;
		s = s1;
	}
	public void getnext(){
		next[0]=-1;
		int j=0,k=-1;
		while(j<size){
			if(k==-1||s[j]==s[k]){
				++j;
				++k;
				if(s[j]!=s[k])
					next[j]=k;
				else
					next[j]=next[k];
			}else k=next[k];
		}
		return;
	}
	public int kmp(int n,char[] b){
		int i=0,j=0;
		while(i<size&&j<n){
			if(i==-1 || s[i]==b[j]){
				++i;
				++j;
			}else i=next[i];
		}
		if(i == size) return i-size+1;
		else return -1;
	}
}
