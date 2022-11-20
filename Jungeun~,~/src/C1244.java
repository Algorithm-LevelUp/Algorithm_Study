package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C1244 {
	private static int count;
	private static int[] numbers;
	private static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//시간초과 방지
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//각 문자로 변환
			String[] str = st.nextToken().split("");
			//교환 횟수
			count = Integer.parseInt(st.nextToken());
			
			//교환횟수가 문자열 길이보다 길 경우, 횟수 = 문자열 길이
			if (count > str.length)
				count = str.length;
			numbers = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				numbers[i] = Integer.parseInt(str[i]);
			}
			result = 0;
			dfs(0, 0);
			sb.append("#" + testCase + " " + result + "\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int k, int move) {
		int t;
		if (move == count) {
			//배열을 문자열로 변환
			String str = Arrays.toString(numbers).replaceAll("[^0-9]", "");
			//비교
			result = Math.max(result, Integer.parseInt(str));
			return;
		}
		int size = numbers.length;
		for (int i = k; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				//swap
				t = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = t;
				
				dfs(i, move + 1);
				//원래대로
				t = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = t;
			}
		}
	}

}
