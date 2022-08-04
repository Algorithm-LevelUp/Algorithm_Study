package first;

/*
 * 부분 수열의 합
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
	private static int[] num;
	private static int N, S, cnt = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정수의 개수
		N = Integer.parseInt(st.nextToken());
		// 정수의 합
		S = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		sum(0, 0);
		if(S == 0)	cnt--;
		System.out.println(cnt);
		
	}
	
	private static void sum(int depth, int total) {
		if(depth == N) {
			if(total == S) cnt++;
			return;
		}
		
		sum(depth + 1, total + num[depth]);
		sum(depth + 1, total);
	}

}
