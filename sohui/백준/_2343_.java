import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class _2343_ { //기타 레슨

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[]arr=new int[n];
		st=new StringTokenizer(bf.readLine());
		int max=0, min=0;
		
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			max+=arr[i];
			if(min<arr[i]) {
				min=arr[i];
			}
		}
		
		int result=max;
		while(min<max) {
			int cnt=1;
			int mid=(min+max)/2;
			
			int check=mid;
			for(int i=0; i<n; i++) {
				if(check-arr[i]>=0) {
					check-=arr[i];
				}else {
					check=mid-arr[i];
					cnt+=1;
				}
			}
			if(cnt>m) {
				min=mid+1;
			}else {
				if(cnt<=m && result>mid) {
					result=mid;
				}
				max=mid;
			}
		}
		System.out.println(result);
	}
}
