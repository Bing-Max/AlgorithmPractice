package greedy;

import java.util.Arrays;

public class MGraph {
	int vertxs;
	char[] data;
	int[][] weight;

	public MGraph(int vertxs) {
		this.vertxs = vertxs;
		this.data = new char[vertxs];
		this.weight = new int[vertxs][vertxs];
	}
	
	public void show() {
		for(int[] line : weight) {
			System.out.println(Arrays.toString(line));
		}
	}
}
