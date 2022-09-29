import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1953_ {
	static int[][] arr;
	static int[][] depth;
	static int cnt;
	static int L;
	static Queue<int[]>queue;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			L= Integer.parseInt(st.nextToken());
			
			arr = new int[n][m];
			depth=new int[n][m];
			cnt=1;
			for (int i = 0; i < n; i++) { // input
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(L>1) {
				search(r, c);
			}
			System.out.println("#"+test_case+" "+cnt);
		}
	}

	public static void search(int r, int c) {

		queue = new LinkedList<>();
		queue.add(new int[] { r, c, arr[r][c]});
		depth[r][c]=1;
		arr[r][c]=0;
		cnt=1;
		
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int num = temp[2];
			if(num==1) {
				up(temp[0], temp[1]);
				down(temp[0], temp[1]);
				left(temp[0], temp[1]);
				right(temp[0], temp[1]);
			}else if(num==2) {
				up(temp[0], temp[1]);
				down(temp[0], temp[1]);
			}else if(num==3) {
				left(temp[0], temp[1]);
				right(temp[0], temp[1]);
			}else if(num==4) {
				up(temp[0], temp[1]);
				right(temp[0], temp[1]);
			}else if(num==5) {
				right(temp[0], temp[1]);
				down(temp[0], temp[1]);
			}else if(num==6) {
				left(temp[0], temp[1]);
				down(temp[0], temp[1]);
			}else if(num==7) {
				up(temp[0], temp[1]);
				left(temp[0], temp[1]);
			}
		}
	}
	public static void up(int x, int y) {
		if(x-1>=0) { // 상
			if(arr[x-1][y]==1||arr[x-1][y]==2 || arr[x-1][y]==5 ||arr[x-1][y]==6) {
				cnt+=1;
				depth[x-1][y]=depth[x][y]+1;
				if(depth[x-1][y]<L) {
					queue.add(new int[] {x-1,y, arr[x-1][y]});
					arr[x-1][y]=0;
				}else {
					arr[x-1][y]=0;
				}
			}
		}
	}
	public static void down(int x, int y) {
		if(x+1<arr.length) { //하
			if(arr[x+1][y]==1 || arr[x+1][y]==2 ||arr[x+1][y]==4|| arr[x+1][y]==7) {
				cnt+=1;
				depth[x+1][y]=depth[x][y]+1;
				if(depth[x+1][y]<L) {
					queue.add(new int[] {x+1,y,arr[x+1][y]});
					arr[x+1][y]=0;
				}else {
					arr[x+1][y]=0;
				}
			}
		}
	}
	public static void left(int x, int y) {
		if(y-1>=0) { //좌
			if(arr[x][y-1]==1 || arr[x][y-1]==3 ||arr[x][y-1]==4|| arr[x][y-1]==5) {
				cnt+=1;
				depth[x][y-1]=depth[x][y]+1;
				if(depth[x][y-1]<L) {
					queue.add(new int[] {x,y-1, arr[x][y-1]});
					arr[x][y-1]=0;
				}else {
					arr[x][y-1]=0;
				}
			}
		}
	}
	public static void right(int x, int y) {
		if(y+1<arr[0].length) { //우
			if(arr[x][y+1]==1 || arr[x][y+1]==3 ||arr[x][y+1]==6|| arr[x][y+1]==7) {
				cnt+=1;
				depth[x][y+1]=depth[x][y]+1;
				if(depth[x][y+1]<L) {
					queue.add(new int[] {x,y+1, arr[x][y+1]});
					arr[x][y+1]=0;
				}else {
					arr[x][y+1]=0;
				}
			}
		}
	}
}
