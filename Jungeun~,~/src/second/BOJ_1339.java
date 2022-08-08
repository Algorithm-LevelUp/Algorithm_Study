package second;

/*
 * 단어 수학
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 단어 수 (최대 10개)
		int n = Integer.parseInt(br.readLine());
		
		int[] alpha = new int[26];
		
		// AAA = 100 * 9 + 10 * 9 + 1 * 9
		// ABC = 100 * 9 + 10 * 8 + 1 * 7
		for(int i = 0; i < n; i++) {
			String word = br.readLine();
			
			int size = word.length();
			
			// 몇번째 자리에 있는지
			int base = (int)Math.pow(10, size - 1);
			
			for(int j = 0; j < size; j++) {
				alpha[word.charAt(j) - 'A'] += base;
				base /= 10;
			}
		}
		
		// 오름차순 정렬
		Arrays.sort(alpha);
		
		int answer = 0;
		
		// 0 ~ 9 값 매기기
		for(int x = 25; x >= 17; x--) {
			answer += alpha[x] * (x - 16);
		}
		
		System.out.println(answer);
		
	}

}
