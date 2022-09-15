package seventh;

/*
 * 연속합
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
	private static int[] arr, dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 음수가 있을 수 있으므로
		int max = arr[0];
		dp = new int[N];
		dp[0] = arr[0];
		
		for(int i = 1; i < N; i++) {
			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}

}
