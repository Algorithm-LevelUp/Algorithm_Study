import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2589_ { // 보물섬
	static int max=Integer.MIN_VALUE;
	static void search(char[][] arr, int a, int b) {
		int[]dx={-1,1,0,0};
		int[]dy={0,0,-1,1};
		
		boolean[][]visited=new boolean[arr.length][arr[0].length]; // 방문 여부
		int[][] depth=new int[arr.length][arr[0].length]; // 이동 시간
		
		Queue<int[]> queue=new LinkedList<>();
		queue.add(new int[] {a,b});
		visited[a][b]=true;
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			for(int i=0; i<4; i++) {
				int x=temp[0]+dx[i];
				int y=temp[1]+dy[i];
				if(x>=0 && x<arr.length && y>=0 && y<arr[0].length) {
					if(!(visited[x][y]) && arr[x][y]=='L') { // 아직 방문 x && 육지 
						visited[x][y]=true;
						if(depth[x][y]==0) {
							depth[x][y]=depth[temp[0]][temp[1]]+1;
						}else {
							if(depth[x][y]>depth[temp[0]][temp[1]]+1) {
								depth[x][y]=depth[temp[0]][temp[1]]+1;
							}
						}
						if(max<depth[x][y]) {
							max=depth[x][y];
						}
						queue.add(new int[] {x,y});
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		char[][]arr=new char[n][m];
		for(int i=0; i<n; i++) { // input
			String s=bf.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]=='L') {
					search(arr,i, j);
				}
			}
		}
		System.out.println(max);
	}
}
