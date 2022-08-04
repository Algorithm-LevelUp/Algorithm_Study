package first;

/*
 * 인간-컴퓨터 상호작용
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16139 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		// 질문의 수
		int q = Integer.parseInt(br.readLine());

		// 합
		// 행 = alphabet
		// 열 = str의 크기
		int[][] sum = new int[26][str.length() + 1];

		for (int c = 1; c < str.length() + 1; c++) {
			for (int i = 0; i < 26; i++) {
				sum[i][c] = sum[i][c - 1];
				if (str.charAt(c - 1) == 'a' + i)	sum[i][c]++;
			}
		}

		while(q--> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char alpha = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			int idx = alpha - 'a';

			sb.append(sum[idx][end + 1] - sum[idx][start]).append('\n');
		}
		System.out.println(sb);
	}

}
