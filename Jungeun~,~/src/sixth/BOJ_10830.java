package sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830 {
	private static int[][] A;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		A = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		int[][] result = pow(A, m);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	private static int[][] pow(int[][] origin, long n) {
		if(n == 1L) {
			return origin;
		}
		
		int[][] tmp = pow(origin, n / 2);
		
		tmp = mul(tmp, tmp);
		
		if(n % 2 == 1L) {
			tmp = mul(tmp, A);
		}
		
		return tmp;
	}

	private static int[][] mul(int[][] o1, int[][] o2){
		int[][] tmp = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					tmp[i][j] += o1[i][k] * o2[k][j];
					tmp[i][j] %= 1000;
				}
			}
		}
		
		return tmp;
	}
}
