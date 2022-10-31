import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11401_ { // 이항 계수 3
	static int divide=1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		System.out.println((factorial(n) * f(factorial(k), divide-2))%divide * f(factorial(n-k), divide-2)%divide);
	}
	private static long factorial(int num) {
		long result=1;
		for(int i=1; i<=num; i++) {
			result=result*i % divide;
		}
		return result;
	}
	private static long f(long b, int i) {
		if(i==1) return b;
		long num=f(b, i/2)%divide;
		num=num*num % divide;
		if(i%2==0) {
			return num;
		}else {
			return num *b %divide;
		}
	}
}
