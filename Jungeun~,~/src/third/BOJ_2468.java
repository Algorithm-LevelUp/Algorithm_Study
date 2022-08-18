package third;

/*
 * 안전 영역
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };
	private static int n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 행과 열의 개수
		n = Integer.parseInt(br.readLine());
		
		int max = 0, min = 100;
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		int result = 1;
		for(int h = min; h < max; h++) {
			visited = new boolean[n][n];
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visited[i][j] && map[i][j] > h) {
						bfs(i, j, h);
						cnt++;
					}
				}
			}
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
		
	}
	
	private static void bfs(int x, int y, int h) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n)	continue;
				if(!visited[nx][ny] && map[nx][ny] > h) {
					q.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
			
		}
	}

}
