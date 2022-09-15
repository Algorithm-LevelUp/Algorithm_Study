import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11727_ { // 2xn 타일링 2

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		
		int l=n;
		if(n<=2) {
			l=2;
		}
		int[]dp=new int[l];
		dp[0]=1;
		dp[1]=3;
		
		for(int i=2; i<n; i++) {
			dp[i]=(dp[i-2]*2+dp[i-1]) %10007;
		}
		System.out.println(dp[n-1]);
	}
}
