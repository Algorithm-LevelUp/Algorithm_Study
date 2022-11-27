import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _9024_ { //두 수의 합

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t=Integer.parseInt(bf.readLine());
		for(int i=0; i<t; i++) {
			st=new StringTokenizer(bf.readLine());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(bf.readLine());
			int[]arr=new int[n];
			for(int j=0; j<n; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			int start=0, end=n-1, temp=Integer.MAX_VALUE, result=0;
			while(start<end) {
				int sum=arr[start]+arr[end];
				if(Math.abs(k-sum)<temp) {
					temp=Math.abs(k-sum);
					result=0;
				}
				if(Math.abs(k-sum)==temp) {
					result+=1;
				}
				if(sum<=k) {
					start+=1;
				}else if(sum>k) {
					end-=1;
				}
			}
			System.out.println(result);
		}
	}
}