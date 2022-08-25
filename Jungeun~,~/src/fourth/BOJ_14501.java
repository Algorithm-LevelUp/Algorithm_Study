package fourth;

/*
 * 퇴사
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 날짜
		// n + 1일째 되는 날 퇴사
		int n = Integer.parseInt(br.readLine());
		
		int[] T = new int[n];
		int[] P = new int[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n + 1];
		for(int i = n - 1; i >= 0; i--) {
			// 상담일
			int time = i + T[i];
			// n일 째까지 근무할 수 있음
			if(time <= n) {
				dp[i] = Math.max(dp[i + 1], P[i] + dp[time]);
			}else	dp[i] = dp[i + 1];
		}
		
		int max = 0;
		// 제일 큰 값
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
