public class Graph<T>{
	private final static int maxNumEdges = 50;	
	private final static int maxNumVertices = 10;
	private SeqList<T> verticesList;
	private int[][] edges = new int[maxNumVertices][maxNumVertices];
	private int currentEdges;
	public Graph( int sz) {
		verticesList = new SeqList<T>(maxNumVertices);
		for ( int i = 0; i < sz; i++ )	
			for ( int j = 0; j < sz; j++ )
				if(i == j)
					edges[i][j] = 0;
				else 
					edges[i][j] = Integer.MAX_VALUE;
		currentEdges = 0;		
	} 
	public boolean isEmpty (){ 
		return verticesList.isEmpty (); 
	}
	public boolean full(){ 
		return !verticesList.isEmpty() || currentEdges == maxNumEdges; 
	}
	public int numberOfVertices(){ 
		return verticesList.size(); 
	}	
	public int numberOfEdges(){ 
		return currentEdges; 
	}
	public int getVertexPos (T vertex){
		return verticesList.find(vertex); 
	}
	public T getValue(int i){			
		return (i >= 0 && i < verticesList.size())?verticesList.get(i):null;
	} 
	  public int getWeight( int v1,  int v2 ) {
		//给出以顶点 v1 和 v2 为两端点的边上的权值
		  if ((v1>=0 && v1<verticesList.size()) &&
		       (v2>=0 && v2<verticesList.size())) 
		       return edges[v1][v2];
		  else throw new IndexOutOfBoundsException();	
		} 
	  public int getFirstNeighbor(int v ) {
		//给出顶点位置为 v 的第一个邻接顶点的位置
		    if (v>=0 && v<verticesList.size()) {
		       for (int col = 0; col<verticesList.size(); col++ )
			 if ( edges[v][col] > 0 && 
		                edges[v][col] < Integer.MAX_VALUE )
		       return col;
		    }  
		   return -1;
		} 
		  
	  public int getNextNeighbor ( int v1,  int v2 ) {
		//给出顶点v1的某邻接顶点v2的下一个邻接顶点 
			   int col;
		    if((v1>=0 && v1<verticesList.size()) &&
		       (v2>=0 && v2<verticesList.size()-1)) {
			      for ( col = v2+1; col <verticesList.size(); col++ ) 
		           if ( edges[v1][col] > 0 && 
		                edges[v1][col] <Integer.MAX_VALUE ) 
		                return col;
		    }
			   return -1;
		}
	  public void insertVertex (T  vertex ){
		  
	  }
	  public void insertEdge( int v1,  int v2, int weight ){
		  
	  }
	  public void removeVertex ( int v ){
		  
	  }
	  public void removeEdge ( int v1,  int v2 ){
		  
	  }
}
