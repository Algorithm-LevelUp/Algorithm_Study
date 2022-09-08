import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2805_ { // 나무 자르기

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(bf.readLine());
		int[]arr=new int[n];
		
		long max=0, min=0;
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		
		long result=0;
		while(min<max) {
			long sum=0;
			long mid=(max+min)/2;
			for(int i=0; i<n; i++) {
				if(arr[i]-mid>0) {
					sum+= arr[i]-mid;
				}
			}
			if(sum>=m) {
				min=mid+1;
				result=mid;
			}else {
				max=mid;
			}
		}
		System.out.println(result);
	}
}
