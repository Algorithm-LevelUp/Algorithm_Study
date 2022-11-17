import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2473_ { // 세 용액
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
		
		int end, start, result1=-1, result2=-1, result3=-1;
		long sum=Long.MAX_VALUE;
		
		for(int i=0; i<n-2; i++) {
			start=i+1;
			end=n-1;
			while(start<end) {
				long temp=Long.valueOf(Long.valueOf(arr[i]+arr[start])+arr[end]);
				if(Math.abs(temp)<Math.abs(sum)) {
					sum=temp;
					result1=i;
					result2=start;
					result3=end;
					if(sum==0)break;
				}
				if(temp<=0) start+=1;
				else if(temp>0) end-=1;
			}
			if(sum==0) break;
		}
		System.out.println(arr[result1]+" "+arr[result2]+" "+arr[result3]);
	}
}