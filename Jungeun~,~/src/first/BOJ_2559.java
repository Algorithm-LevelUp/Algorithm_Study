package first;

/*
 * 수열
 * 누적합
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2559 {
	private static int[] temp;
	private static int n, k;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 배열의 크기
		n = Integer.parseInt(st.nextToken());
		// 합을 구하기 위한 연속적인 날짜의 수
		k = Integer.parseInt(st.nextToken());
		
		// 온도
		temp = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			temp[i] = Integer.parseInt(st.nextToken()) + temp[i - 1];
		}

		int max = Integer.MIN_VALUE;
		for(int i = n; i >= k; i--) {
			max = Math.max(max, temp[i] - temp[i - k]);
		}
		System.out.println(max);
	}
	

}
