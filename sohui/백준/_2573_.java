import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2573_ {
	static int ice_search(int[][] arr, int x, int y) { // 주변 바닷물 count
		int answer = 0;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int i = 0; i < 4; i++) {
			int x_next = x + dx[i];
			int y_next = y + dy[i];
			if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length) {
				if (arr[x_next][y_next] == 0) {
					answer += 1;
				}
			}
		}
		return answer;
	}

	static void search_split(int[][] arr, int[][] visited, int x, int y, int cnt) { //빙산 덩어리 count
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = cnt;
		while (!queue.isEmpty()) {
			int[] temp=queue.poll();
			for (int i = 0; i < 4; i++) {
				int x_next = temp[0] + dx[i];
				int y_next = temp[1] + dy[i];
				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length) {
					if (arr[x_next][y_next] > 0 && visited[x_next][y_next] == 0) { // 빙하 존재
						visited[x_next][y_next] = cnt;
						queue.add(new int[] { x_next, y_next });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) { // input
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;
		while (true) {
			int[][] result = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] != 0) { // 빙하
						int num = arr[i][j] - ice_search(arr, i, j);
						if (num < 0) {
							num = 0;
						}
						result[i][j] = num;
					}
				}
			}
			arr = result;
			int cnt = 1;
			boolean all = false;
			int[][] visited = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] > 0 && visited[i][j] == 0) { // 빙하 && 아직 방문 x
						all = true;
						search_split(arr, visited, i, j, cnt++);
					}
				}
			}

			year += 1;
			if (all == false) { // 빙산이 다 녹을때까지 분리 x
				System.out.println(0);
				break;
			}
			if (cnt >= 3) {
				System.out.println(year);
				break;
			}
		}
	}
}