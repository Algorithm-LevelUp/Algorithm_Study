import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 이차원 배열과 연산
public class _17140_ {
	static int[][] R(int[][] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) { 
				if (o1[1] == o2[1]) // 수의 등장 횟수가 같을때 -> 수가 커지는 순
					return o1[0] - o2[0];
				return o1[1] - o2[1]; // 수의 등장 횟수가 커지는 순
			}
		});

		HashSet<Integer> set = new HashSet<>();
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			set.clear();
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					set.add(arr[i][j]);
				}
			}
			if (max < set.size()) {
				max = set.size();
			}
		}
		if (max > 50) {
			max = 50;
		}

		int[][] result = new int[arr.length][max * 2];

		for (int i = 0; i < arr.length; i++) { // 수와 등장 횟수 구하기
			map.clear();
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					if (map.containsKey(arr[i][j])) {
						map.put(arr[i][j], map.get(arr[i][j]) + 1);
					} else {
						map.put(arr[i][j], 1);
					}
				}
			}
			for (Integer key : map.keySet()) {
				queue.add(new int[] { key, map.get(key) });
			}
			int k = 0;
			while (!queue.isEmpty()) {
				int[] temp = queue.poll();
				if (k >= 100) {
					break;
				}
				result[i][k++] = temp[0];
				result[i][k++] = temp[1];
			}
		}
		return result;
	}

	static int[][] C(int[][] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});

		HashSet<Integer> set = new HashSet<>();
		int max = 0;
		for (int i = 0; i < arr[0].length; i++) {
			set.clear();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j][i] != 0) {
					set.add(arr[j][i]);
				}
			}
			if (max < set.size()) {
				max = set.size();
			}
		}
		if (max > 50) {
			max = 50;
		}

		int[][] result = new int[max * 2][arr[0].length];

		for (int i = 0; i < arr[0].length; i++) {  // 수와 등장 횟수 구하기
			map.clear();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j][i] != 0) {
					if (map.containsKey(arr[j][i])) {
						map.put(arr[j][i], map.get(arr[j][i]) + 1);
					} else {
						map.put(arr[j][i], 1);
					}
				}
			}
			for (Integer key : map.keySet()) {
				queue.add(new int[] { key, map.get(key) });
			}
			int k = 0;
			while (!queue.isEmpty()) {
				int[] temp = queue.poll();
				if (k >= 100) {
					break;
				}
				result[k++][i] = temp[0];
				result[k++][i] = temp[1];
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[3][3];
		for (int i = 0; i < 3; i++) { // input
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		while (true) {
			if (r - 1 >= 0 && r - 1 < arr.length && c - 1 >= 0 && c - 1 < arr[0].length) {
				if (arr[r - 1][c - 1] == k) {
					break;
				}
			}
			if (arr.length >= arr[0].length) { // 행의 개수 >= 열의 개수
				arr = R(arr);
			} else { // 행의 개수 < 열의 개수
				arr = C(arr);
			}
			time += 1;
			if (time > 100) { // break 조건
				time = -1;
				break;
			}
		}
		System.out.println(time);
	}
}