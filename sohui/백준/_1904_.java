import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1904_ {// 01타일

	public static void main(String[] args) throws IOException { 
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		
		long[]arr=new long[n+1];
		if(n==1) {
			arr[1]=1;
		}else if(n==2) {
			arr[2]=2;
		}
		if(n>2) {
			arr[1]=1;
			arr[2]=2;
			for(int i=3; i<n+1; i++) {
				arr[i]=(arr[i-1]+arr[i-2]) % 15746;
			}
		}

		System.out.println(arr[n]);
	}
}
