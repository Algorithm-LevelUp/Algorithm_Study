package fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197 {
	static class Edge implements Comparable<Edge>{
		int to, cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge arg0) {
			return this.cost - arg0.cost;
		}
	}

	private static List<Edge>[] edges;
	private static boolean[] visited;
	private static int min = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList[v + 1];
		for(int i = 0; i <= v; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[a].add(new Edge(b, c));
			edges[b].add(new Edge(a, c));
		}
		
		visited = new boolean[v + 1];
		prim();
		System.out.println(min);
	}
	
	private static void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>() ;
		
		pq.add(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(visited[now.to])	continue;
			
			visited[now.to] = true;
			min += now.cost;
			
			for(Edge edge : edges[now.to]) {
				if(!visited[edge.to])	pq.add(edge);
			}
		}
	}

}
