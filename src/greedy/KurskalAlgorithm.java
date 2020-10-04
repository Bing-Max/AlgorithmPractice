package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class KurskalAlgorithm {

	public static void main(String[] args) {

		int vertxs = 7;
		char[] data = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };

		int[][] weight = { { -1, 12, -1, -1, -1, 16, 14 }, { 12, -1, 10, -1, -1, 7, -1 }, { -1, 10, -1, 3, 5, 6, -1 },
				{ -1, -1, 3, -1, 4, -1, -1 }, { -1, -1, 5, 4, -1, 2, 8 }, { 16, 7, 6, -1, 2, -1, 9 },
				{ 14, -1, -1, -1, 8, 9, -1 } };
		MGraph graph = KurskalMinTree.createMGraph(vertxs, data, weight);
		KurskalMinTree.showGrapgh(graph);
		KurskalMinTree.kurskal(graph);
	}

}

class KurskalMinTree {
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

	public static void kurskal(MGraph graph) {

		// 获得排序后的边
		Edge[] edges = getEdges(graph);

		// 记录顶点的终点，默认是0
		int[] ends = new int[graph.vertxs];

		// 总共寻找n-1条边
		Edge[] res = new Edge[graph.vertxs - 1];

		int j = 0;
		for (int i = 0; i < res.length; i++) {
			for (; j < edges.length; j++) {

				// 获得两顶点的下标
				int pos1 = getEnd(ends, getPosition(graph.data, edges[j].ver1));
				int pos2 = getEnd(ends, getPosition(graph.data, edges[j].ver2));

				// 判断终点
				if (getEnd(ends, pos1) != getEnd(ends, pos2)) {
					// 边加入结果集
					res[i] = edges[j];
					// 更新终点表
					ends[pos1] = pos2;
					break;
				}
			}
		}

		System.out.println(Arrays.toString(res));
	}

	public static Edge[] getEdges(MGraph graph) {
		ArrayList<Edge> list = new ArrayList<Edge>();
		for (int i = 0; i < graph.vertxs - 1; i++) {
			for (int j = i + 1; j < graph.vertxs; j++) {
				if (graph.weight[i][j] != -1) {
					list.add(new Edge(graph.data[i], graph.data[j], graph.weight[i][j]));
				}
			}
		}

		Edge[] edges = new Edge[list.size()];
		for (int i = 0; i < edges.length; i++) {
			edges[i] = list.get(i);
		}
		Arrays.sort(edges);
		return edges;
	}

	public static int getEnd(int[] ends, int i) {
		// 一直循环到终点
		while (ends[i] != 0) {
			i = ends[i];
		}

		return i;
	}

	public static int getPosition(char[] data, char c) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == c) {
				return i;
			}
		}

		return -1;
	}
}

class Edge implements Comparable<Edge> {
	char ver1;
	char ver2;

	int weight;

	public Edge(char ver1, char ver2, int weight) {
		this.ver1 = ver1;
		this.ver2 = ver2;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [ver1=" + ver1 + ", ver2=" + ver2 + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}

}