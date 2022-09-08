package sixth;

/*
 * 예산
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 개수
		int n = Integer.parseInt(br.readLine());
		
		// 금액 리스트
		int[] money = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(money);
		// 상한가
		int limit = Integer.parseInt(br.readLine());
		
		int left = 0;
		int right = money[n - 1];
		
		while(left <= right) {
			int mid = (left + right) / 2;
			long value = 0;
			for(int i = 0; i < n; i++) {
				if(money[i] > mid) 	value += mid;
				else				value += money[i];
			}
			if(value <= limit)  left = mid + 1;
			else				right = mid - 1;
		}
		
		System.out.println(right);
	}

}
