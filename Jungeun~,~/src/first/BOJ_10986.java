package first;
/*
 * 나머지 합
 * 누적 합
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10986 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 배열의 크기
		int n = Integer.parseInt(st.nextToken());
		// 나누는 수
		int m = Integer.parseInt(st.nextToken());
		
		// 합
		int sum = 0;
		// 나머지 배열 = 부분 수열의 개수
		int[] cnt = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			// 합의 나머지
			sum  = (Integer.parseInt(st.nextToken()) + sum) % m;
			cnt[sum]++;
		}
		
		// 개수
		long answer = cnt[0];
		for(int i = 0; i < m; i++) {
			// 조합 nCr
			answer += (long)cnt[i] * (cnt[i] - 1) / 2;
		}
		
		System.out.println(answer);
	}
}
