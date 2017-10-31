
public class Matrix {
	public int[][] matrix;
	public int row,column;
	public Matrix(int i,int j){
		matrix = new int [i][j];
		row = i;
		column = j;
	}
	public void set(int i,int j,int value){
		matrix[i][j] = value;
	}
	public void add(Matrix a){
		for(int i=0;i<row;++i)
			for(int j=0;j<column;++j)
				matrix[i][j] += a.matrix[i][j];
		return;
	}
	public Matrix multiply(Matrix a){
		if(column != a.row) 
			throw new ArrayIndexOutOfBoundsException();
		Matrix answer = new Matrix(row,a.column);
		answer.row = row;
		answer.column = a.column;
		for(int i=0;i<row;++i)
			for(int j=0;j<a.column;++j){
				answer.matrix[i][j] = 0;
				for(int k=0;k<column;++k)
					answer.matrix[i][j] += matrix[i][k] * a.matrix[k][j];
			}
		return answer;
	}
	public void transpose(){
		if(row != column)
			throw new ArrayIndexOutOfBoundsException();
		for(int i=1;i<row;++i)
			for(int j=0;j<i;++j){
				int mid = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = mid;
			}
		return;
	}
	public void print(){
		for(int i=0;i<row;++i){
			for(int j=0;j<column;++j){
				if(j!=0) System.out.print(' ');
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
//	public static void main(String[] args){
//		Matrix a = new Matrix(5,5), b = new Matrix(5,5),newone;
//		for(int i=0;i<5;++i)
//			for(int j=0;j<5;++j){
//				a.set(i, j, i+j);
//				b.set(j, i, i+j+1);
//			}
//		newone = a.multiply(b);
//		newone.print();
//		newone.transpose();
//		System.out.println();
//		newone.print();
//	}
}
