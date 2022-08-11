package second;

/*
 * 상근이의 여행
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9372 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		while(t--> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 국가의 수
			int n = Integer.parseInt(st.nextToken());
			// 비행기의 종류
			int m = Integer.parseInt(st.nextToken());
			
			int[][] tree = new int[n + 1][n + 1];
			// a와 b를 왕복하는 비행기
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				tree[a][b] = tree[b][a] = 1;
			}
			
			System.out.println(n - 1);
		}
		
	}

}
