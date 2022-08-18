import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16234_ { //인구 이동
	static boolean check;
	static int answer=0;
	
	static void search(int[][] arr, boolean[][] visited, int l, int r, int x, int y) {
		int[] dx = { -1, 1, 0, 0 }; // 상하좌우
		int[] dy = { 0, 0, -1, 1 };
		
		Queue<int[]> queue=new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y]=true;
		
		List<int[]> list=new ArrayList<>(); //연합
		list.add(new int[] {x,y});
		
		int sum=arr[x][y];
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			for(int i=0; i<4; i++) {
				int x_num=temp[0]+dx[i];
				int y_num=temp[1]+dy[i];
				if(x_num>=0 && x_num<arr.length && y_num>=0 && y_num<arr.length) {
					if(!(visited[x_num][y_num])) {
						int minus=Math.abs(arr[temp[0]][temp[1]]-arr[x_num][y_num]);
						if(minus>=l && minus<=r) {
							visited[x_num][y_num]=true;
							sum+=arr[x_num][y_num];
							queue.add(new int[] {x_num,y_num});
							list.add(new int[] {x_num,y_num});
						}
					}
				}
			}
		}
		if(list.size()>1) { //인구 이동
			check=true;
			for(int i=0; i<list.size(); i++) {
				arr[list.get(i)[0]][list.get(i)[1]]=sum/list.size();
			}
		}		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) { // input
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(true) {
			boolean[][]visited=new boolean[n][n];
			check=false;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(visited[i][j]==false) {
						visited[i][j]=true;
						search(arr, visited, l, r, i, j);
					}
				}
			}
			if(check==false) {
				break;
			}
			answer+=1;
		}
		System.out.println(answer);
	}
}
