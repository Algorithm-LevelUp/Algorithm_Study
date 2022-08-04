import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650_ { // N과 M (2)
	static int[] arr;

	public static void search(int n, int m, int idx, int start) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < n; i++) {

			arr[idx] = i + 1;
			search(n, m, idx + 1, i + 1);

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[m];

		int start = 0;
		search(n, m, 0, start);
	}
}
