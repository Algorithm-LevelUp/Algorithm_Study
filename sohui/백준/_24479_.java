import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _24479_ { //알고리즘 수업 - 깊이 우선 탐색 1
	static int[] answer;
	static int idx=1;
	
	static void dfs(List<List<Integer>> list, int start, boolean[] visited) {
		visited[start]=true;
		answer[start-1]=idx++;
		for(int i=0; i<list.get(start).size(); i++) {
			if(visited[list.get(start).get(i)]==false) {
				dfs(list, list.get(start).get(i), visited);
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		
		List<List<Integer>> list=new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(bf.readLine());
			
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i=1; i<n+1; i++) {
			Collections.sort(list.get(i));
		}
		boolean visited[]=new boolean[n+1];
		answer=new int[n];
		
		dfs(list, R, visited);
		
		for(int i=0; i<n; i++) {
			System.out.println(answer[i]);
		}
	}
}