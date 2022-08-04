import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _14888_ { // 연산자 끼워넣기
	static int visited[];;
	static int arr[];
	static int op_arr[];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void search(int[] op, int n, int idx) {
		int num = arr[0];
		if (idx == n) {
			for (int i = 0; i < n; i++) {
				if (op_arr[i] == 0) {
					num += arr[i + 1];
				} else if (op_arr[i] == 1) {
					num -= arr[i + 1];
				} else if (op_arr[i] == 2) {
					num *= arr[i + 1];
				} else {
					if (num < 0) {
						num *= -1;
						num /= arr[i + 1];
						num *= -1;
					} else {
						num /= arr[i + 1];
					}
				}
			}
			if (max < num) {
				max = num;
			}
			if (min > num) {
				min = num;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				op_arr[idx] = op[i];
				search(op, n, idx + 1);
				visited[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		arr = new int[n];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(bf.readLine());
		int[] op = new int[n - 1];
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				op[idx] = i;
				idx += 1;
			}
		}

		int start = 0;
		visited = new int[n - 1];
		op_arr = new int[n - 1];
		search(op, n - 1, 0);

		System.out.println(max);
		System.out.println(min);
	}
}
