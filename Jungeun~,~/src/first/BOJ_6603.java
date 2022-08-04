package first;

/*
 * 로또 번호 생성
 * 백트래킹
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
	private static StringBuilder sb;
	private static boolean[] checked;
	private static int[] numbers;
	private static int k;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb =  new StringBuilder();
			k = Integer.parseInt(st.nextToken());
			
			// 0을 입력받을 때 
			if(k == 0) break;
			
			numbers = new int[k];
			checked = new boolean[k];
			for(int i =0; i < k; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			lotto(0, 0);
			System.out.println(sb);
		}
	}
	
	private static void lotto(int depth, int start) {
		if(depth == 6) {
			for(int i = 0; i < k; i++) {
				if(checked[i])
					sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < k; i++) {
			checked[i] = true;
			lotto(depth + 1,i + 1);
			checked[i] = false;
		}
	}

}
