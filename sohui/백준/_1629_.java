import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1629_ { // 곱셈
	static long multiple(int a, int b, int c) {
		if(b==1) {
			return a%c;
		}
		long num=multiple(a, b/2, c);
		if(b%2==0) {
			return (num%c)*(num%c)%c;
		}else {
			return ((num%c)*(num%c))%c*(a%c) %c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		long result=multiple(a,b,c);
		System.out.println(result);

	}
}