package seventh;
/*
 * 배낭 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
	private static int[][] goods;
	private static Integer[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		goods = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// 무게
			goods[i][0] = Integer.parseInt(st.nextToken());
			// 가치
			goods[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new Integer[n][k + 1];
		
		System.out.println(knapsack(n - 1, k));
	}
	
	private static int knapsack(int idx, int k) {
		if(idx < 0)	return 0;
		
		if(dp[idx][k] == null) {
			// 최대 무게를 넘긴 경우
			if(goods[idx][0] > k)	dp[idx][k] = knapsack(idx - 1, k);
			else					dp[idx][k] = Math.max(knapsack(idx - 1 , k),knapsack(idx - 1, k - goods[idx][0]) + goods[idx][1]);
		}
		
		return dp[idx][k];
	}

}
