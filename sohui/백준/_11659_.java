

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11659_ {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken()); // 수의 개수
		int m=Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

		int[] arr = new int[n]; // n개의 수
		st=new StringTokenizer(bf.readLine());
		arr[0]=Integer.parseInt(st.nextToken());

		for (int i = 1; i < n; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) { // 구간 입력
			st =new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			if (start == 0) {
				System.out.println(arr[end]);
			} else {
				System.out.println(arr[end] - arr[start - 1]);
			}
		}
	}
}
