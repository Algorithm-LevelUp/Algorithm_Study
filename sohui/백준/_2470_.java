import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2470_ { // 두 용액

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n=Integer.parseInt(bf.readLine());
		int[]arr=new int[n];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start=0, end=n-1, sum=Integer.MAX_VALUE;
		int result1=-1, result2=-1, temp=0;
		while(start<end) {
			temp=arr[start]+arr[end];
			if(sum>Math.abs(temp)) {
				result1=start;
				result2=end;
				sum=Math.abs(temp);
				if(sum==0) break;
			}
			if(temp<0) {
				start+=1;
			}else if(temp>0) {
				end-=1;
			}
		}	
		System.out.println(arr[result1] + " "+arr[result2]);
	}
}
