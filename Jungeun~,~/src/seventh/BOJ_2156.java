package seventh;

/*
 * 포도주 시식
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
	private static Integer[] dp;
	private static int[] number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		number = new int[N + 1];
		dp = new Integer[N + 1];

		for (int i = 1; i <= N; i++) {
			number[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 0;
		dp[1] = number[1];
		
		if(N > 1)
			dp[2] = number[1] + number[2];
		System.out.println(wine(N));
	}

	private static int wine(int i) {
		if(dp[i] == null)
			dp[i] = Math.max(Math.max(wine(i - 2), wine(i - 3) + number[i - 1]) + number[i], wine(i - 1));
		return dp[i];
	}
}
