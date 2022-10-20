import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11722_ { // 가장 긴 감소하는 부분 수열

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int a=Integer.parseInt(bf.readLine());
		int[]arr=new int[a];
		st=new StringTokenizer(bf.readLine());
		for(int i=0; i<a; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int[]dp=new int[a];
		for(int i=0; i<a; i++) {
			dp[i]=1;
			if(a==1) break;
			for(int j=0; j<i; j++) {
				if(arr[j]>arr[i] && dp[j]+1>dp[i]) {
					dp[i]=dp[j]+1;
				}
			}
		}
		int answer=0;
		for(int i=0; i<a; i++) {
			if(answer<dp[i]) answer=dp[i];
		}
		System.out.println(answer);
	}
}
