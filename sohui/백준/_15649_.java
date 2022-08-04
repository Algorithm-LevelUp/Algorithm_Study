import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649_ { // N과 M (1)
	static int[] arr;
	static int[] visited;

	public static void search(int n, int m, int idx) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				arr[idx] = i + 1;
				search(n, m, idx + 1);
				visited[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		visited = new int[n];

		search(n, m, 0);
	}
}
