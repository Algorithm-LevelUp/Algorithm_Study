package third;

/*
 * 섬의 개수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {
	// 팔방 탐색
	private static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
	private static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
	private static int[][] map;
	private static boolean[][] visited;
	private static int w, h;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 너비
			w = Integer.parseInt(st.nextToken());
			// 높이
			h = Integer.parseInt(st.nextToken());
			// 테스트 종료
			if(w == 0 && h == 0)	break;
			
			map = new int[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			visited = new boolean[h][w];
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					// 섬일 때
					if(!visited[i][j] && map[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= h || ny < 0 || ny >= w)	continue;
			if(!visited[nx][ny] && map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}

}
