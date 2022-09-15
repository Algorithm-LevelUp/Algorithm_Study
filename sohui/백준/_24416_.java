import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24416_ { //알고리즘 수업-피보나치 수 1
	static int result1=1;
	static int fibo_r(int n) {
		if(n==1 || n==2) {
			return 1;
		}else {
			result1+=1;
			return fibo_r(n-1)+fibo_r(n-2);
		}	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		
		fibo_r(n);
		
		int result2=n-2; // dp count
		
		System.out.println(result1+" "+result2);
	}
}
