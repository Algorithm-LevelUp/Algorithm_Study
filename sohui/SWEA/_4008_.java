import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class _4008_ {
	static int[] num, result, op;
	
	static int max, min;
	public static void main(String args[]) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(bf.readLine()); 
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int n=Integer.parseInt(bf.readLine());
			
			op=new int[4];
			num=new int[n];
			result=new int[n-1];
			
			min=Integer.MAX_VALUE;
			max=Integer.MIN_VALUE;
			
			st=new StringTokenizer(bf.readLine());
			for(int i=0; i<4; i++) {
				op[i]=Integer.parseInt(st.nextToken());
			}
			
			st=new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			search(n-1, 0, num[0]);
			System.out.println("#"+test_case+" "+ (max-min));
		}
	}
	private static void search(int limit, int idx, int temp) {
		if(idx==limit) {
			if(min>temp) min=temp;
			if(max<temp) max=temp;
			return;
		}
		if(op[0]>0) {
			result[idx]=0;
			op[0]-=1;
			search(limit, idx+1, temp+num[idx+1]);
			op[0]+=1;
		}
		if(op[1]>0) {
			result[idx]=1;
			op[1]-=1;
			search(limit, idx+1, temp-num[idx+1]);
			op[1]+=1;
		}
		if(op[2]>0) {
			result[idx]=2;
			op[2]-=1;
			search(limit, idx+1, temp*num[idx+1]);
			op[2]+=1;
		}
		if(op[3]>0) {
			result[idx]=3;
			op[3]-=1;
			search(limit, idx+1, temp/num[idx+1]);
			op[3]+=1;
		}
	}
}