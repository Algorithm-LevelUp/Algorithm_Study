import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17142_ { // 연구소 3
	static int[][] arr, depth;
	static List<int[]> list;
	static int[] result;
	static int n;
	static boolean[][] visited;
	
	static int[]dx= {-1,1,0,0};
	static int[]dy= {0,0,-1,1};
	
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		list = new ArrayList<>();
		result=new int[m];
		answer=Integer.MAX_VALUE;
		
		int cnt=0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					list.add(new int[] { i, j });
				}
				if(arr[i][j]==0) cnt+=1;
			}
		}
		if(cnt>0) {
			search(m, 0, 0);
			if(answer==Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(answer);
		}else {
			System.out.println(0);
		}
	}

	private static void search(int limit, int start, int idx) {
		if (idx == limit) {
			depth=new int[n][n];
			visited=new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]==1) visited[i][j]=true;
				}
			}
			move();
			int time=0;
			boolean flag=true;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j]) {
						flag=false;
						break;
					}
					if(depth[i][j]>time) time=depth[i][j];
				}
			}
			if(flag) {
				if(answer>time) answer=time;
			}
			return;
		}
		for(int i=start; i<list.size(); i++) {
			result[idx]=i;
			search(limit, i+1, idx+1);
		}
	}

	private static void move() {
	
		
		Queue<int[]> queue=new LinkedList<>();
		for(int i=0; i<result.length; i++) {
			queue.add(new int[] {list.get(result[i])[0],list.get(result[i])[1]});
			visited[list.get(result[i])[0]][list.get(result[i])[1]]=true;
		}
		
		while(!queue.isEmpty()) {
			int cnt=0;
			int[] temp=queue.poll();
			for(int i=0; i<4; i++) {
				int x=temp[0]+dx[i];
				int y=temp[1]+dy[i];
				if(x>=0 && x<n && y>=0 && y<n) {
					if(!visited[x][y]) { 
						if(arr[temp[0]][temp[1]]==2 && arr[x][y]==0) cnt+=1;
						queue.add(new int[] {x,y});
						visited[x][y]=true;
						depth[x][y]=depth[temp[0]][temp[1]]+1;
					}
				}
			}
			if(arr[temp[0]][temp[1]]==2 && cnt==0) depth[temp[0]][temp[1]]=0;
		}
	}

}
