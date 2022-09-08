import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class _2630_ { // 색종이 만들기
	static int white=0;
	static int blue=0;
	
	static void divide(int n, int [][] arr, int x, int y) {
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
			divide(n/2, arr, x, y);
			divide(n/2, arr, x+n/2, y);
			divide(n/2, arr, x, y+n/2);
			divide(n/2, arr, x+n/2, y+n/2);
		}else {
			if(num==0) {
				white+=1;
			}else {
				blue+=1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n=Integer.parseInt(bf.readLine());
		int[][]arr=new int[n][n];
		
		for(int i=0; i<n; i++) { //input
			st=new StringTokenizer(bf.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		divide(n, arr, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}
}
