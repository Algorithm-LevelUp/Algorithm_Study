package eleventh;

/*
 * 연구소
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
	private static int[][] map;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };
	private static int n, m, max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m]; // 0: 안전지대, 1: 벽, 2: 바이러스
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(max);

	}

	private static void dfs(int cnt) {
		if (cnt == 3) {
			int total = 0;
			boolean[][] visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && map[i][j] == 0)
						total += check(i, j, visited);
				}
			}

			max = Math.max(max, total);
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0)
					continue;
				map[i][j] = 1;
				dfs(cnt + 1);
				map[i][j] = 0;
			}
		}
	}

	private static int check(int x, int y, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		int total = 1;
		boolean flag = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)	continue;
				if (map[nx][ny] == 2) {
					flag = false;
					continue;
				}
				if (map[nx][ny] == 1 || visited[nx][ny])	continue;

				q.add(new int[] { nx, ny });
				visited[nx][ny] = true;
				total++;
			}
		}
		if (!flag)	total = 0;
		return total;
	}

}
