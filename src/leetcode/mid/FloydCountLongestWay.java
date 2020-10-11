package leetcode.mid;

import java.util.Scanner;

/**
 * 很久以前，某王国拥有 n 个大城市，为了方便交通，国王下令修建了大量的用于连接首都和其他各大城市高速路。

为节省经费，王国采用了一套优秀的修建方案，使得任何一个大城市都能从首都直接或者通过其他大城市间接到达。并且，如果不重复经过大城市，从首都到达每个大城市的方案都是唯一的。

G商队是王国重要的运输商队，他们奔波于各大城市之间，为王国的人们运输商品，实现长途贸易。所以，从一个城市马不停蹄地到另一个城市成了G商队最常做的事情。他们有一个钱袋，用于存放往来城市间的运输费。

在运输过程中G商队发现，如果不在某个城市停下来休整，在连续行进过程中，他们所花的运输费与他们已走过的距离有关，在走第x千米到第x+1千米这一千米中（x是整数），他们花费的运输费是x+10这么多。也就是说走1千米花费11，走2千米要花费23。

G商队想知道：他们从某一个城市出发，如果中间不休息，到达另一个城市，所有可能花费的运输费中最多是多少呢？
 * @author BingMax
 * @Statement:
 *
 */
public class FloydCountLongestWay {
	
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N, p, q, des;
        
        while(sc.hasNextInt()){
            N = sc.nextInt();
            if(N <= 1){
                System.out.println(0);
                continue;
            }
            int [][] map = new int[N][N];
            for(int i = 0; i < N; i++) {
            	for(int j = 0; j < N; j++) {
            		map[i][j] = 1024;
            	}
            }
            for(int i = 0; i < N -1; i++){
                p = sc.nextInt();
                q = sc.nextInt();
                des = sc.nextInt();
                map[p - 1][q - 1] = des;
                map[q - 1][p - 1] = des;
            }
            
            int len = longWay(map);
            System.out.println(cost(len));
        }
        
        
    }
    
    public static int cost(int n){
        if(n <=0){
			return 0;
        }
        return n * 10 + (1 + n) * n / 2;
    }
    
    // 核心就是弗洛伊德，但是前提是要能想到 - > 唯一路径就是最短路径。
    // 不能重复到达一个城市。
    public static int longWay(int[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                for(int k = 0; k < map.length; k++){
                    if(map[i][j] > map[i][k] + map[k][j] ){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i <  map.length; i++){
//        	System.out.println(Arrays.toString(map[i]));
            for(int j = i + 1; j < map.length; j++){
                if(map[i][j] > max){
                    max = map[i][j];
                }
            }
        }
        
        return max;
    }

}
