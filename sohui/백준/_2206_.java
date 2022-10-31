import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206_ { // 벽 부수고 이동하기
	static int arr[][], depth[][][],n,m;
	static boolean visited[][][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr=new int[n][m];
		depth=new int[n][m][2];
		visited=new boolean[n][m][2];
		for(int i=0; i<n; i++) {
			String s=bf.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}
		search();
		int answer=Integer.MAX_VALUE;
		if(depth[n-1][m-1][0] !=0) {
			answer=depth[n-1][m-1][0];
		}
		if(depth[n-1][m-1][1]!=0 && answer>depth[n-1][m-1][1]) {
			answer=depth[n-1][m-1][1];
		}
		if(answer==Integer.MAX_VALUE) answer=-1;
		System.out.println(answer);
	}
	private static void search() {
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int[] {0,0,0});
		depth[0][0][0]=1;
		visited[0][0][0]=true;
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			
			for(int i=0; i<4; i++) {
				int x=temp[0]+dx[i];
				int y=temp[1]+dy[i];
				if(x>=0 && x<n && y>=0 && y<m) {
					if(arr[x][y]==0) {
						if(!visited[x][y][temp[2]] || depth[x][y][temp[2]]>depth[temp[0]][temp[1]][temp[2]]+1) {
							visited[x][y][temp[2]]=true;
							depth[x][y][temp[2]]=depth[temp[0]][temp[1]][temp[2]]+1;
							queue.add(new int[] {x,y,temp[2]});
						}
					}
					if(arr[x][y]==1 && temp[2]==0) {
						if(!visited[x][y][temp[2]+1] || depth[x][y][temp[2]+1]>depth[temp[0]][temp[1]][temp[2]]+1) {
							visited[x][y][temp[2]+1]=true;
							depth[x][y][temp[2]+1]=depth[temp[0]][temp[1]][temp[2]]+1;
							queue.add(new int[] {x,y,1});
						}
					}
				}
			}
		}
	}
}
