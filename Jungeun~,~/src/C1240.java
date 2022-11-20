package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1240 {
	private static String[] binaries = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111",
			"0111011", "0110111", "0001011" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			String code = "";

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				if (code.isEmpty()) {
					//끝은 항상 1
					for (int j = M - 1; j >= 0; j--) {
						if (input.charAt(j) == '1') {
							code = input.substring(j - 55, j + 1);
							break;
						}
					}
				}
			}
			System.out.println("#" + testCase + " " + isValid(code));
		}
	}

	private static int isValid(String code) {
		int num[] = toNum(code);
		int sum = 0;
		int total = 0;

		for (int i = 0; i < num.length; i++) {
			sum += num[i];
			//0부터 시작해서 짝수 자리 -> 홀수자리
			if (i % 2 == 0)
				total += 3 * num[i];
			else
				total += num[i];
		}
		
		if (total % 10 == 0)
			return sum;

		return 0;
	}

	private static int[] toNum(String s) {
		//8자리
		int[] num = new int[8];
		int idx = 0;
		for (int i = 0; i < s.length(); i += 7) {
			//7비트씩 cut
			String tmp = s.substring(i, i + 7);
			for (int j = 0; j < 10; j++) {
				if (tmp.equals(binaries[j])) {
					num[idx++] = j;
					break;
				}
			}
		}
		return num;
	}

}
