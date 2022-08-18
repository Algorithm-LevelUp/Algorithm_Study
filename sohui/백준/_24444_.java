import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _24444_ { // 알고리즘 수업-너비 우선 탐색1
	static int[] answer;
	static void bfs(int n,List<List<Integer>> list, int start) {
		boolean []visited=new boolean[n+1];
		
		visited[start]=true;
		Queue<Integer>queue=new LinkedList<>();
		queue.add(start);
		int idx=1;
		answer[start-1]=idx++;
		
		while(!queue.isEmpty()) {
			int temp=queue.poll();
			for(int i=0; i<list.get(temp).size(); i++) {
				if(visited[list.get(temp).get(i)]==false) {
					visited[list.get(temp).get(i)]=true;
					queue.add(list.get(temp).get(i));
					answer[list.get(temp).get(i)-1]=idx++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken()); // 정점 수
		int m = Integer.parseInt(st.nextToken()); // 간선 수
		int r = Integer.parseInt(st.nextToken()); // 시작 정점

		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) { // 간선 정보
			st = new StringTokenizer(bf.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list.get(u).add(v);
			list.get(v).add(u);
		}

		for (int i = 1; i < n + 1; i++) { // 오름차순
			Collections.sort(list.get(i));
		}
		answer=new int[n];
		bfs(n, list, r);
		
		for(int i=0; i<n; i++) {
			System.out.println(answer[i]);
		}
	}

}
