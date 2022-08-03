

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559_ {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());
		int[] arr = new int[n];
		arr[0]=Integer.parseInt(st.nextToken());

		for (int i = 1; i < n; i++) { //합
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}
		
		int max=arr[k-1];
		for(int i=k; i<n; i++) { //연속적인 k일의 온도의 합
			if(max<arr[i]-arr[i-k]) {
				max=arr[i]-arr[i-k];
			}
		}
		System.out.println(max);
	}
}
