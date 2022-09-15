import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2193_ { //이친수
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		
		long[][]arr=new long[n][2];
		arr[0][1]=1;
		
		for(int i=1; i<n; i++) {
			arr[i][1]=arr[i-1][0];
			arr[i][0]=arr[i-1][0]+arr[i-1][1];
		}
		System.out.println(arr[n-1][0]+arr[n-1][1]);
	}
}
