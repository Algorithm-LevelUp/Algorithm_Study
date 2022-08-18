package third;

/*
 * 너비 우선 탐색 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_24445 {
	private static int n;
	private static int[] seq;
	private static List<Integer>[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정점의 개수
		n = Integer.parseInt(st.nextToken());
		// 간선의 개수
		int m = Integer.parseInt(st.nextToken());
		// 시작 정점
		int r = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		
		// 내림차순
		for(int i = 1; i <= n; i++) {
			Collections.sort(map[i]);
			Collections.reverse(map[i]);
		}
		
		seq = new int[n + 1];
		bfs(r);
		
		for(int i = 1; i <= n; i++) {
			System.out.println(seq[i]);
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		int cnt = 1;
		
		// 시작점
		queue.offer(start);
		seq[start] = cnt++;
		
		while(!queue.isEmpty()) {
			int idx = queue.poll();
			
			for(int node : map[idx]) {
				// 다음 노드
				int next = node;
				// 방문한 노드이면 반복문으로 돌아가기
				if(seq[next] != 0)	continue;
				queue.offer(next);
				seq[next] = cnt++;
			}
		}
	}

}
