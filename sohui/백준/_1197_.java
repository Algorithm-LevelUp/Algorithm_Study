import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1197_ {
	static class Node{
		int vertex, weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int V=Integer.parseInt(st.nextToken()); // 정점의 개수
		int E=Integer.parseInt(st.nextToken()); // 간선의 개수
		
		Node[]list=new Node[V+1];
		
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			list[a]=new Node(b,c,list[a]);
			list[b]=new Node(a,c, list[b]);
		}
		
		int minEdge[]=new int[V+1];
		boolean[] visited=new boolean[V+1];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[1]=0;
		long answer=0;
		
		for(int i=1; i<=V; i++) {
			int min=Integer.MAX_VALUE;
			int minVertext=-1;
			for(int j=1; j<=V; j++) {
				if(!visited[j] && min>minEdge[j]) {
					min=minEdge[j];
					minVertext=j;
				}
			}
			
			visited[minVertext]=true;
			answer+=min;
			
			for(Node temp=list[minVertext]; temp!=null; temp=temp.next) {
				if(!visited[temp.vertex] && minEdge[temp.vertex]>temp.weight) {
					minEdge[temp.vertex]=temp.weight;
				}
			}
		}
		System.out.println(answer);
	}
}