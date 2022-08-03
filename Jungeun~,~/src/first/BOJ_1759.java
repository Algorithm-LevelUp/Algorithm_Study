package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 암호 만들기
 */

public class BOJ_1759 {
	private static int l, c;
	private static char[] words, list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 암호를 구성할 수 있는 문자 개수
		l = Integer.parseInt(st.nextToken());
		// 문자의 개수
		c = Integer.parseInt(st.nextToken());
		words = new char[c];
		list = new char[l];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			words[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(words);

		password(0, 0);
	}

	private static void password(int depth, int start) {
		if (depth == l) {
			if(isValid()) 	System.out.println(list);
			return;
		}

		for (int i = start; i < c; i++) {
			list[depth] = words[i];
			password(depth + 1, i + 1);
		}
	}

	// 유효성 검사
	// 최소 한개의 모음, 최소 2개의 자음
	private static boolean isValid() {
		// 모음
		int conso = 0;
		// 자음
		int vowels = 0;

		for (char x : list) {
			if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
				conso++;
			} else {
				vowels++;
			}
		}

		if (conso >= 1 && vowels >= 2) {
			return true;
		}

		return false;
	}
}
