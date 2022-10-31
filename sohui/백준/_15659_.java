import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _15659_ { //연산자 끼워넣기 (3)
	static int arr[], op[], result[];
	static int max, min, n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader  bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(bf.readLine());
		arr=new int[n];
		st=new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		op=new int[4];
		result=new int[n-1];
		st=new StringTokenizer(bf.readLine());
		for(int i=0; i<4; i++) {
			op[i]=Integer.parseInt(st.nextToken());
		}
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		search(0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void search(int idx) {
		if(idx==n-1) {
			Stack<Integer>stack=new Stack<>();
			stack.add(arr[0]);
			int num=1;
			while(true) {
				if(result[num-1]==2 || result[num-1]==3) {
					int temp=stack.pop();
					if(result[num-1]==2) {
						stack.add(temp*arr[num]);
					}else {
						if(temp<0) {
							temp-=(2*temp);
							temp/=arr[num];
							temp-=(2*temp);
						}else {
							temp/=arr[num];
						}
						stack.add(temp);
					}
				}else {
					stack.add(result[num-1]);
					stack.add(arr[num]);
				}
				num+=1;
				if(num==n)break;
			}
			int sum=stack.get(0);
			int i=1;
			while(i<stack.size()) {
				if(i%2==1) { // 연산자이면
					if(stack.get(i)==0) {
						sum+=stack.get(i+1);
					}else if(stack.get(i)==1) {
						sum-=stack.get(i+1);
					}
				}
				i+=2;
			}
			if(sum>max) max=sum;
			if(sum<min) min=sum;
			return;
		}
		if(op[0]>0) {
			op[0]-=1;
			result[idx]=0;
			search(idx+1);
			op[0]+=1;
		}
		if(op[1]>0) {
			op[1]-=1;
			result[idx]=1;
			search(idx+1);
			op[1]+=1;
		}
		if(op[2]>0) {
			op[2]-=1;
			result[idx]=2;
			search(idx+1);
			op[2]+=1;
		}
		if(op[3]>0) {
			op[3]-=1;
			result[idx]=3;
			search(idx+1);
			op[3]+=1;
		}
	}
}