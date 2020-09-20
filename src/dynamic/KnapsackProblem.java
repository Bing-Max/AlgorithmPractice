package dynamic;

import java.util.Arrays;

/**
 * 0-1 背包问题
 * 
 * @author BingMax
 * @Statement:
 *
 */
public class KnapsackProblem {
	public static void main(String[] args) {

		int N = 4;
		int wei[] = { 1, 4, 3 };
		int val[] = { 1500, 3000, 2000 };

		// 最后的价值数组
		int v[][] = new int[val.length + 1][N + 1];

		// 如果放入了对应的物品，那么就将物品放入
		boolean isPicked[][] = new boolean[val.length + 1][N + 1];

		// 初始化数组
		// 第0列置0
		for (int i = 0; i < v.length; i++) {
			v[i][0] = 0;
		}

		// 第0行置空
		for (int j = 0; j < v[0].length; j++) {
			v[0][j] = 0;
		}

		for (int i = 1; i < v.length; i++) { // 按行计算，忽略第0行
			for (int j = 1; j < v[0].length; j++) { // 按列计算，忽略第0列

				if (wei[i - 1] > j) { // 物品重量大于当前的背包容量
					// 不放
					v[i][j] = v[i - 1][j];
				} else {
					// 比较加入新的物品和加该物品之前（上一行）的大小，确定是否加入该物品
					// 可以保证没有该物品之前，上一行的同列数据就是最大值
					// v[i][j] = Math.max(val[i - 1] + v[i - 1][j - wei[i - 1]], v[i - 1][j]);
					if (val[i - 1] + v[i - 1][j - wei[i - 1]] > v[i - 1][j]) {
						v[i][j] = val[i - 1] + v[i - 1][j - wei[i - 1]];
						// 将商品放入背包, i 代表第 i 个物品， j 代表当前背包重量
						isPicked[i][j] = true;
					} else {
						v[i][j] = v[i - 1][j];
						// 物品没有放入背包
					}
				}
			}
		}

		for (int[] row : v) {
			System.out.println(Arrays.toString(row));
		}
		
		// 逆向输出，因为我们存放的数组中存放了新加的商品
		int i = isPicked.length - 1;
		int j = isPicked[0].length - 1;
		while(i > 0 && j > 0) {
			if(isPicked[i][j]) {
				System.out.printf("第%d个物品放入背包\n", i);
				j -= wei[i - 1];
			}
			i--;
		}
	}

}
