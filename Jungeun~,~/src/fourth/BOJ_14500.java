package fourth;

/*
 * 테트로미노
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int[][] map;
	private static boolean[][] visited;
	private static int n, m, max = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 행
		n = Integer.parseInt(st.nextToken());
		// 열
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i =  0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 모든 배열에 대해
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visited[i][j] = true;
				// x, y, cnt, sum
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
			}
		}
		
		System.out.println(max);
	}
	
	private static void dfs(int x, int y, int cnt, int sum) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위를 벗어날 때
			if(nx < 0 || nx >= n || ny < 0 || ny >= m)	continue;
			
			// 방문하지 않은 노드에 대해서
			if(!visited[nx][ny]) {
				// ㅗ모양을 위해 2번째 카운트에서 다시 탐색
				if(cnt == 2) {
					visited[nx][ny] = true;
					// x, y에 대해서 다시 탐색
					dfs(x, y, cnt + 1, sum + map[nx][ny]);
					visited[nx][ny] = false;
				}
				
				visited[nx][ny] = true;
				dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}

}
