package third;

/*
 * 깊이 우선 탐색 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_24480 {
	private static List<Integer>[] map;
	private static int[] cnt;
	private static boolean[] visited;
	private static int n, total = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정점의 개수
		n = Integer.parseInt(st.nextToken());
		// 간선의 개수
		int m = Integer.parseInt(st.nextToken());
		// 시작 정점
		int r = Integer.parseInt(st.nextToken());

		// 노드의 방문 순서
		cnt = new int[n + 1];
		map = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}

		visited = new boolean[n + 1];
		// 내림차순
		for(int i = 1; i <= n; i++) {
			Collections.sort(map[i]);
			Collections.reverse(map[i]);
		}
		// r부터 시작
		dfs(r);
		for (int i = 1; i <= n; i++) {
			System.out.println(cnt[i]);
		}
	}

	private static void dfs(int x) {
		visited[x] = true;
		cnt[x] = ++total;

		for (int next: map[x]) {
			if(visited[next])	continue;
			dfs(next);
		}

	}

}
