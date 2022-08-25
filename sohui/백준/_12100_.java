import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2048 (Easy)
public class _12100_ {
	static int n, max_val = Integer.MIN_VALUE;
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };
	static int[] result = new int[5];
	static int[][] arr;

	static void search(int num, int limit, int idx) {
		if (idx == limit) {
			int[][] copy_arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					copy_arr[i][j] = arr[i][j];
				}
			}
			for (int k = 0; k < 5; k++) {
				if (result[k] == 0) { // 위
					boolean visited[][] = new boolean[n][n];
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							int temp = copy_arr[i][j];
							copy_arr[i][j] = 0;
							if (temp != 0) {
								int x = i - 1, y = j;
								while (true) {
									if (x >= 0) { // 범위 안
										if (copy_arr[x][y] == temp) { // 같은 값이면
											if (!visited[x][y]) { // 아직 합친 적이 없으면
												copy_arr[x][y] += copy_arr[x][y];
												visited[x][y] = true;
												break;
											} else {
												copy_arr[x + 1][y] = temp;
												break;
											}
										} else if (copy_arr[x][y] != temp) {
											if (copy_arr[x][y] == 0) {
												x -= 1;
											} else {
												copy_arr[x + 1][y] = temp;
												break;
											}
										}
									} else {
										if (x == -1) {
											copy_arr[x + 1][y] = temp;
										}
										break;
									}
								}
							}
						}
					}
				} else if (result[k] == 1) { // 아래
					boolean visited[][] = new boolean[n][n];
					for (int i = n - 1; i >= 0; i--) {
						for (int j = 0; j < n; j++) {
							int temp = copy_arr[i][j];
							copy_arr[i][j] = 0;
							if (temp != 0) {
								int x = i + 1, y = j;
								while (true) {
									if (x < n) { // 범위 안
										if (copy_arr[x][y] == temp) { // 같은 값이면
											if (!visited[x][y]) { // 아직 합친 적이 없으면
												copy_arr[x][y] += copy_arr[x][y];
												visited[x][y] = true;
												break;
											} else {
												copy_arr[x - 1][y] = temp;
												break;
											}
										} else if (copy_arr[x][y] != temp) {
											if (copy_arr[x][y] == 0) {
												x += 1;
											} else {
												copy_arr[x - 1][y] = temp;
												break;
											}
										}
									} else {
										if (x == n) {
											copy_arr[x - 1][y] = temp;
										}
										break;
									}
								}
							}
						}
					}
				} else if (result[k] == 2) {// 좌
					boolean visited[][] = new boolean[n][n];
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							int temp = copy_arr[i][j];
							copy_arr[i][j] = 0;
							if (temp != 0) {
								int x = i, y = j - 1;
								while (true) {
									if (y >= 0) { // 범위 안
										if (copy_arr[x][y] == temp) { // 같은 값이면
											if (!visited[x][y]) { // 아직 합친 적이 없으면
												copy_arr[x][y] += copy_arr[x][y];
												visited[x][y] = true;
												break;
											} else {
												copy_arr[x][y + 1] = temp;
												break;
											}
										} else if (copy_arr[x][y] != temp) {
											if (copy_arr[x][y] == 0) {
												y -= 1;
											} else {
												copy_arr[x][y + 1] = temp;
												break;
											}
										}
									} else {
										if (y == -1) {
											copy_arr[x][y + 1] = temp;
										}
										break;
									}
								}
							}
						}
					}
				} else {
					boolean visited[][] = new boolean[n][n];
					for (int i = 0; i < n; i++) { // 우
						for (int j = n - 1; j >= 0; j--) {
							int temp = copy_arr[i][j];
							copy_arr[i][j] = 0;
							if (temp != 0) {
								int x = i, y = j + 1;
								while (true) {
									if (y < n) { // 범위 안
										if (copy_arr[x][y] == temp) { // 같은 값이면
											if (!visited[x][y]) { // 아직 합친 적이 없으면
												copy_arr[x][y] += copy_arr[x][y];
												visited[x][y] = true;
												break;
											} else {
												copy_arr[x][y - 1] = temp;
												break;
											}
										} else if (copy_arr[x][y] != temp) {
											if (copy_arr[x][y] == 0) {
												y += 1;
											} else {
												copy_arr[x][y - 1] = temp;
												break;
											}
										}
									} else {
										if (y == n) {
											copy_arr[x][y - 1] = temp;
										}
										break;
									}
								}
							}
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (max_val < copy_arr[i][j]) {
						max_val = copy_arr[i][j];
					}
				}
			}
			return;
		}

		for (int i = 0; i <= num; i++) {
			result[idx] = i;
			search(num, limit, idx + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) { // input
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		search(3, 5, 0);
		System.out.println(max_val);
	}
}