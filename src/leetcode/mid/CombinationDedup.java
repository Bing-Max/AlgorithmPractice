package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationDedup {

	public static void main(String[] args) {
		CombinationDedup obj = new CombinationDedup();
		int candidates[] = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		obj.combinationSum2(candidates, target);

		for (List list : obj.combinations) {
			System.out.println(list.toString());
		}
	}

	private int[] candidates;
	private List<List<Integer>> combinations;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		this.candidates = candidates;
		combinations = new ArrayList<>();
		List<Integer> com = new ArrayList<Integer>();
		combination(com, 0, target);

		return combinations;
	}

	public void combination(List cur, int pos, int rest) {
		if (rest == 0) {
			combinations.add(cur);
			return;
		}

		if (pos >= candidates.length) {
			return;
		}
		
		if (candidates[pos] > rest) {
			combination(cur, pos + 1, rest);
		}

		if (candidates[pos] <= rest) {
			List<Integer> list = new ArrayList();
			list.addAll(cur);
			combination(list, pos + 1, rest);

			cur.add(candidates[pos]);
			combination(cur, pos + 1, rest - candidates[pos]);

		}


	}

}
