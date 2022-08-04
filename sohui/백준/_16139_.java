import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _16139_ { // 인간-컴퓨터 상호작용

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		String S = st.nextToken(); // 문자열

		st = new StringTokenizer(bf.readLine());
		int q = Integer.parseInt(st.nextToken()); // 질문 수

		int[][] sum = new int[26][S.length()];

		for (int i = 0; i < S.length(); i++) {
			int temp = (S.charAt(i) - 97);
			if (i == 0) {
				sum[temp][i] = 1;
			} else {
				sum[temp][i] = sum[temp][i - 1] + 1;
			}
			for (int j = 0; j < 26; j++) {
				if (j != temp && i != 0) {
					sum[j][i] = sum[j][i - 1];
				}
			}
		}
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(bf.readLine());
			char a = (st.nextToken()).charAt(0);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int result = 0;
			if (x == 0) {
				result = sum[a - 97][y];
			} else {
				result = sum[a - 97][y] - sum[a - 97][x - 1];
			}
			bw.write(String.valueOf(result));
			bw.write("\n");
		}
		bw.flush();
	}
}
