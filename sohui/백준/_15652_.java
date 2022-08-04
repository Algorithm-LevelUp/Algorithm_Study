import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _15652_ { // N과 M (4)
	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void search(int n, int m, int idx, int start) throws IOException {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = start; i < n; i++) {
			arr[idx] = i + 1;
			search(n, m, idx + 1, i);

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

		bw.flush();
	}
}
