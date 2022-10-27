import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2156_ { // 포도주 시식
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		int[] arr=new int[n];
		int[] dp=new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		
		if(n==1) {
			dp[0]=arr[0];
		}else if(n==2) {
			dp[1]=arr[0]+arr[1];
		}else if(n==3) {
			dp[1]=arr[0]+arr[1];
			dp[2]=Math.max(dp[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));
		}else {
			dp[0]=arr[0];
			dp[1]=arr[0]+arr[1];
			dp[2]=Math.max(dp[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));
			for(int i=3; i<n; i++) {
				dp[i]=Math.max(dp[i-1], arr[i]+Math.max(dp[i-3]+arr[i-1], dp[i-2]));
			}
		}
		int answer=0;
		for(int i=0; i<n; i++) {
			if(answer<dp[i]) answer=dp[i];
		}
		System.out.println(answer);
	}
}
