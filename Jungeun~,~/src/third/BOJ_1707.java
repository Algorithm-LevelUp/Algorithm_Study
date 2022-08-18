package third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1707 {
	private static int[] colors;
	private static List<Integer>[] list;
	private static boolean isBinary;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// test case
		int k = Integer.parseInt(br.readLine());
		
		while(k-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V + 1];
			for(int i = 0; i <= V; i++) {
				list[i] =new ArrayList<>();
			}
			
			for(int i = 0; i < E; i++) {
				 st = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				list[u].add(v);
				list[v].add(u);
			}
			
			colors = new int[V + 1];
			isBinary = true;
			for(int i = 1; i <= V; i++) {
				if(!isBinary)	break;
				if(colors[i] == 0)	dfs(i, 1);
			}
			
			System.out.println(isBinary ? "YES" : "NO");
		}
		
	}
	
	private static void dfs(int x, int color) {
		colors[x] = color;
		
		for(int value : list[x]) {
			if(colors[value] == color)	{
				isBinary = false;
				return;
			}
			if(colors[value] == 0)	dfs(value, color * -1);
		}
	}

}
