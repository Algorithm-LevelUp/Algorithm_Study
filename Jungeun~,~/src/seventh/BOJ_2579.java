package seventh;

/*
 * 계단오르기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
	private static Integer[] dp;
	private static int[] stairs;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1];
		stairs = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = stairs[0];
		dp[1] = stairs[1];
		
		if(N >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}
		
		System.out.println(up(N));
	}

	private static int up(int n) {
		if(dp[n] == null)
			dp[n] = Math.max(up(n - 2), up(n - 3) + stairs[n - 1]) + stairs[n];
		return dp[n];
	}
}
