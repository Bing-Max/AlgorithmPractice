package structure.tree.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	private int[][] edges;
	private List<String> vertexs;

	private int numOfEdges;
	// 记录某个结点是否被访问
	private boolean[] isVisited;

	public Graph() {
		// TODO Auto-generated constructor stub
	}

	public Graph(int n) {
		this.edges = new int[n][n];
		this.vertexs = new ArrayList<String>();
		this.numOfEdges = 0;
		this.isVisited = new boolean[n];
	}

	public void insertVertex(String vertex) {
		this.vertexs.add(vertex);
	}

	public void insertEdges(int v1, int v2, int weight) {
		this.edges[v1][v2] = weight;
		this.edges[v2][v1] = weight;

		this.numOfEdges++;
	}

	public String getVertex(int i) {
		return this.vertexs.get(i);
	}

	public void showGraph() {
		for (int[] links : this.edges) {
			System.out.println(Arrays.toString(links));
		}
	}

	public int getNums() {
		return this.numOfEdges;
	}
	
	public int getFirstNeighbor(int index) {
		for(int j = 0; j < vertexs.size(); j++) {
			if(edges[index][j] > 0) {
				return j;
			}
		}
		
		return -1;
	}
	
	public int getNextNeighbor(int v1, int v2) {
		for(int i = v2 + 1; i < vertexs.size(); i++) {
			if(edges[v1][i] > 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	private void dfs(boolean[] isVisited, int index) {
		System.out.print(vertexs.get(index) + "->");
		// isVisited 数组对应位置置true，表示已经遍历过
		isVisited[index] = true;
		
		int w = getFirstNeighbor(index);
		while(w != -1) {
			if(isVisited[w] == false) {
				dfs(isVisited, w);
			}
			
			w = getNextNeighbor(index, w);
			
		}
		
	}
	
	public void dfs() {
		// 遍历所有结点
		for(int i = 0; i < vertexs.size(); i++) {
			if(isVisited[i] == false) {
				dfs(isVisited, i);
			}
		}
	}
	
	// 广度优先
	private void bfs(boolean[] isVisited, int i) {
		System.out.print(vertexs.get(i) + "->");
		isVisited[i] = true;
		
		int u;// 队列头结点
		int w;// 队列头的邻接结点
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addLast(i);
		while(!queue.isEmpty()) {
			u = queue.removeFirst();
			w = getFirstNeighbor(u); // 得到第一个邻接结点
			while(w != -1) {
				if(!isVisited[w]) {
					System.out.print(vertexs.get(w) + "->");
					isVisited[w] = true;
					queue.addLast(w);
				}
				// 接着找下一个邻接结点，如果一个结点被遍历过，那对应的，他连接的结点也应该都遍历过了
				w = getNextNeighbor(u, w);
			}
			
		}
	}
	
	// 所有结点进行广度优先遍历
	private void bfs() {
		for(int i = 0; i < vertexs.size(); i++) {
			if(!isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}

	public static void main(String[] args) {
		int n = 5;
		String[] vertexs = { "A", "B", "C", "D", "E" };
		Graph graph = new Graph(n);
		
		for(String vertex: vertexs) {
			graph.insertVertex(vertex);
		}
		
		graph.insertEdges(0, 1, 1);
		graph.insertEdges(0, 2, 1);
//		graph.insertEdges(1, 2, 1);
		graph.insertEdges(1, 3, 1);
		graph.insertEdges(1, 4, 1);
		
//		graph.showGraph();
		graph.dfs();
//		graph.bfs();
	}

}
