package greedy;

import java.util.Arrays;

import structure.tree.graph.Graph;

public class FloydAlgorithm {

	public static void main(String[] args) {
		int vertxs = 7;
		char[] data = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };

		int[][] weight = { { -1, 5, 7, -1, -1, -1, 2 }, { 5, -1, -1, 9, -1, -1, 3 }, { 7, -1, -1, -1, 8, -1, -1 },
				{ -1, 9, -1, -1, -1, 4, -1 }, { -1, -1, 8, -1, -1, 5, 4 }, { -1, -1, -1, 4, 5, -1, 6 },
				{ 2, 3, -1, -1, 4, 6, -1 } };

		MGraph graph = new MGraph(vertxs);
		graph.data = data;
		graph.weight = weight;
		
		FloydGraph fgraph = new FloydGraph(graph);
		fgraph.floyd();
		fgraph.graph.show();
		
	}
}

class FloydGraph {
	// 记录图，也就是距离
	MGraph graph;

	// 前驱是二维数组，记录对应两个点的最短路径的前驱
	int[][] pre_vertex;

	public FloydGraph(MGraph graph) {
		// TODO Auto-generated constructor stub
		this.graph = graph;
		this.pre_vertex = new int[graph.vertxs][graph.vertxs];

		Arrays.fill(pre_vertex, -1);
	}

	public void floyd() {

		for (int j = 0; j < graph.vertxs; j++) {
			for (int i = 0; i < graph.vertxs; i++) {
				for (int k = 0; k < graph.vertxs; k++) {
					if (graph.weight[i][j] == -1 || graph.weight[j][k] == -1 || i == k || j == k || i == j) {
						continue;
					}
					// 比较 vi vk 与 (vi, vj) + (vj, vk)
					if (graph.weight[i][k] == -1 || graph.weight[i][k] > graph.weight[i][j] + graph.weight[j][k]) {
						graph.weight[i][k] = graph.weight[i][j] + graph.weight[j][k];

						// 更新前驱结点
						pre_vertex[i][k] = pre_vertex[j][k];
					}
				}
			}
		}
	}
}