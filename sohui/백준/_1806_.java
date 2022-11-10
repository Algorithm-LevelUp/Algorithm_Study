import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1806_ { // 부분합

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		int[]arr=new int[n];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int []sum=new int[n+1];
		sum[1]=arr[0];
		for(int i=1; i<n; i++) {
			sum[i+1]=sum[i]+arr[i];
		}
		
		int start=0, end=0, result=Integer.MAX_VALUE;
		while(end<=n) {
			if(sum[end]-sum[start]>=s) {
				if(end-start<result) {
					result=end-start;
				}
				start+=1;
			}
			if(sum[end]-sum[start]<s) {
				end+=1;
			}
		}
		if(result==Integer.MAX_VALUE)System.out.println(0);
		else System.out.println(result);
	}
}
