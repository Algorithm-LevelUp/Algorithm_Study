package third;

/*
 * 뱀과 사다리 게임
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
	private static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 사다리의 개수
		int n = Integer.parseInt(st.nextToken());
		// 뱀의 개수
		int m = Integer.parseInt(st.nextToken());
		// 사다리
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map.put(x, y);
			
		}
		// 뱀
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map.put(u, v);
		}
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		int[] cnt = new int[101];
		Arrays.fill(cnt, -1);
		
		Queue<int[]> q = new LinkedList<>();
		
		// 위치, 횟수
		q.add(new int[] {1, 0});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 6; i > 0; i--) {
				int next = now[0] + i;
				
				// 위치를 벗어날 때
				if(next > 100 || next < 1)	continue;
				if(map.containsKey(next)) {
					next = map.get(next);
				}
				// 방문하지 않았을 때
				if(cnt[next] == -1) {
					cnt[next] = now[1] + 1;
					q.offer(new int[] {next, now[1] + 1});
				}
			}
		}
		return cnt[100];
	}

}
