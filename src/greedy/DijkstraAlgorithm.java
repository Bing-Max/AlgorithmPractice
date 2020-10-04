package greedy;

import java.util.Arrays;

public class DijkstraAlgorithm {
	
	public static void main(String[] args) {
		int vertxs = 7;
		char[] data = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };

		int[][] weight = { { -1, 5, 7, -1, -1, -1, 2 }, { 5, -1, -1, 9, -1, -1, 3 }, { 7, -1, -1, -1, 8, -1, -1 },
				{ -1, 9, -1, -1, -1, 4, -1 }, { -1, -1, 8, -1, -1, 5, 4 }, { -1, -1, -1, 4, 5, -1, 6 },
				{ 2, 3, -1, -1, 4, 6, -1 } };
		
		MGraph graph = new MGraph(vertxs);
		graph.data = data;
		graph.weight = weight;
		
		VisitedVertex vv = new VisitedVertex();
//		vv.dijstra(graph, 0);
		vv.dijstra(graph, 0, 3);
		
	}

}

class VisitedVertex{
	
	// 表示每个结点是否已经访问过
	public boolean[] already_arr;
	// 用来记录路径上的前去结点
	public int[] pre_visited;
	// 用来记录每个顶点的最短距离
	public int[] dis;
	
	public MGraph grapgh;
	
	// 初始化
	public void init(MGraph graph, int index) {
		
		this.grapgh = graph;
		int length = graph.vertxs;
		this.already_arr = new boolean[length];
		this.pre_visited = new int[length];
		this.dis = new int[length];
		// 填充表示每个节点的距离都是无穷
		Arrays.fill(dis, -1);
		
		// 表示该节点已经访问过
		this.already_arr[index] = true;
		this.pre_visited[index] = -1;
		this.dis[index] = 0;
	}
	
	public void updataDis(int index, int len) {
		this.dis[index] = len;
	}
	
	public void updatePre(int index, int pre) {
		this.pre_visited[index] = pre;
	}
	
	
	public int getDis(int index) {
		return dis[index];
	}
	
	public void dijstra(MGraph graph,int index, int end) {
		// 开始寻找最短路径
		this.dijstra(graph, index);
		
		int i = end;
		StringBuilder sub = new StringBuilder();
		while(i != -1) {
			sub.insert(0, grapgh.data[i]);
			i = pre_visited[i];
			if(i != -1) {				
				sub.insert(0, "->");
			}
		}
		
		System.out.println(sub.toString());
	}
	
	public void dijstra(MGraph graph, int index) {
//		VisitedVertex vv = new VisitedVertex(graph.vertxs, index);
		this.init(graph, index);
		
		updateDis(index);
		
		while(!isEnd()) {			
			int minIndex = 0;
			int min = -1;
			for(int i = 0; i < this.already_arr.length; i++) {
				if(!already_arr[i] && dis[i] != -1) {
					if(min == -1 || dis[i] < min) {
						min = dis[i];
						minIndex = i;
					}
				}
			}
			// 标记下一个最短的点为ture
			already_arr[minIndex] = true;
			updateDis(minIndex);
		}
		
//		System.out.println(Arrays.toString(pre_visited));
	}
	
	public void updateDis(int index) {
		// 新加入结点之后，更新Dis 数组
		for(int i = 0; i < grapgh.vertxs; i++) {
			// 更新Dis
			if(!already_arr[i] && grapgh.weight[index][i] != -1) {
				if(dis[i] == -1 || dis[i] > grapgh.weight[index][i] + dis[index]) {
					// 更新表
					dis[i] = grapgh.weight[index][i] + dis[index];
					pre_visited[i] = index;
				}
			}
		}
	}
	
	public boolean isEnd() {
		for(boolean flag : already_arr) {
			if(!flag) {
				return false;
			}
		}
		return true;
	}
}

