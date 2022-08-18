package third;

/*
 * 적록색약
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026 {
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };
	private static char[][] map;
	private static boolean[][] visited;
	private static int cnt, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 적록색약이 아닌 사람이 봤을 때
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					blind(i, j);
					cnt++;
				}
			}
		}

		System.out.print(cnt + " ");

		// 적록 색약인 사람이 봤을 때
		visited = new boolean[n][n];
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'R')
					map[i][j] = 'G';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					blind(i, j);
					cnt++;
				}
			}
		}

		System.out.print(cnt);
	}

	private static void blind(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
				continue;
			if (!visited[nextX][nextY] && map[x][y] == map[nextX][nextY]) {
				blind(nextX, nextY);
			}
		}
	}

}
