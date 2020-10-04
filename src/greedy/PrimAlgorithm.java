package greedy;

import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.DADD;

public class PrimAlgorithm {

	public static void main(String[] args) {
		int vertxs = 7;
		char[] data = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };

		int[][] weight = { { -1, 5, 7, -1, -1, -1, 2 }, { 5, -1, -1, 9, -1, -1, 3 }, { 7, -1, -1, -1, 8, -1, -1 },
				{ -1, 9, -1, -1, -1, 4, -1 }, { -1, -1, 8, -1, -1, 5, 4 }, { -1, -1, -1, 4, 5, -1, 6 },
				{ 2, 3, -1, -1, 4, 6, -1 } };
		MGraph graph = MinTree.createMGraph(vertxs, data, weight);
		MinTree.showGrapgh(graph);
		MinTree.prim(graph, 5);
	}

}

class MinTree {

	public static void showGrapgh(MGraph graph) {

		for (int[] lins : graph.weight) {
			System.out.println(Arrays.toString(lins));
		}
	}

	public static MGraph createMGraph(int vertxs, char[] data, int[][] weight) {
		MGraph mGraph = new MGraph(vertxs);
		mGraph.data = data;
		mGraph.weight = weight;
		return mGraph;
	}

	/**
	 * 
	 * @param graph
	 * @param ver   起始顶点
	 */
	public static void prim(MGraph graph, int ver) {
		boolean[] visited = new boolean[graph.vertxs];

		// 标记该顶点已访问
		visited[ver] = true;

		// 寻找下一个最短的边
		for (int i = 0; i < graph.vertxs - 1; i++) {
			// 总共需要寻找N-1条边
			// 寻找的方式从已经访问过的顶点开始，寻找相关联的没访问过的顶点的最小权值的边

			int h1 = -1;// 已访问过的顶点
			int h2 = -1;// 未访问过的顶点
			for (int j = 0; j < graph.vertxs; j++) {
				if (!visited[j]) {
					continue;
				}

				for (int k = 0; k < graph.vertxs; k++) {
					if (visited[k] || graph.weight[j][k] == -1) {
						continue;
					}
					if (h1 == -1) {
						h1 = j;
						h2 = k;
						continue;
					}

					if (graph.weight[j][k] < graph.weight[h1][h2]) {
						h1 = j;
						h2 = k;
					}
				}
			}

			visited[h2] = true;
			System.out.printf("%c - %c: %d\n", graph.data[h1], graph.data[h2], graph.weight[h1][h2]);

		}
	}
}

