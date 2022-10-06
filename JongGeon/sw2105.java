import java.util.Scanner;

public class sw2105 {
	
	static int dx[] = {-1,1,1,-1};
	static int dy[] = {1,1,-1,-1};
	static int arr[][] = new int[20][20];
	static int n;
	static int start_x;
	static int start_y;
	static int answer = -1;
	static boolean visit[]= new boolean[101];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int test =sc.nextInt();
		
		for(int t=1; t<=test; t++) {
			n= sc.nextInt();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j]= sc.nextInt();
				}
			}
			answer = -1;
			for(int k=1; k<=100; k++) {
				visit[k]=false;
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					
					if(i==2 && j==0) {
						System.out.println();
					}
					start_x = i;
					start_y = j;
					cafe(i,j, 0, 0);
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
		
	}
	
	static void cafe(int x, int y, int d, int c) {
		if(x<0 || y < 0 || x >= n || y >= n ) return;
		
		if(visit[arr[x][y]]) {
			if(start_x == x && start_y == y) {
				if(answer < c)
					answer = c;
			}
			return;
		}
		
		visit[arr[x][y]]=true;
		
		int nx = x+dx[d];
		int ny = y+dy[d];
		if(d+1<=3) {
			cafe(nx,ny,d+1,c+1);
		}
		cafe(nx,ny,d,c+1);
		visit[arr[x][y]]=false;
	}
}
