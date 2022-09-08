import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1780_ { // 종이의 개수
	static int result1=0, result2=0, result3=0;
	
	static void divide(int n, int[][]arr, int x, int y) {
		boolean check=false;
		int num=arr[x][y];
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(num!=arr[i][j]) {
					check=true;
					break;
				}
			}
			if(check) {
				break;
			}
		}
		
		if(check) {
			divide(n/3, arr, x, y);
			divide(n/3, arr, x+n/3, y);
			divide(n/3, arr, x+(n/3)*2, y);
			divide(n/3, arr, x, y+n/3);
			divide(n/3, arr, x+n/3, y+n/3);
			divide(n/3, arr, x+(n/3)*2, y+n/3);
			divide(n/3, arr, x, y+(n/3)*2);
			divide(n/3, arr, x+n/3, y+(n/3)*2);
			divide(n/3, arr, x+(n/3)*2, y+(n/3)*2);
		}else {
			if(num==-1) {
				result1+=1;
			}else if(num==0) {
				result2+=1;
			}else {
				result3+=1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n=Integer.parseInt(bf.readLine());
		int[][]arr=new int[n][n];
		
		for(int i=0; i<n; i++) { // input
			st=new StringTokenizer(bf.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		divide(n, arr, 0 ,0);
		System.out.println(result1+"\n"+result2+"\n"+result3);
		
	}
}
