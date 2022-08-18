import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6118_ { //숨바꼭질
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	static int[] depth;
	
	static void search(int start) {
		Queue<Integer>queue=new LinkedList<>();
		queue.add(start);
		visited[start]=true;
		
		while(!queue.isEmpty()) {
			int temp=queue.poll();
			for(int i=0; i<list.get(temp).size(); i++) {
				if(!visited[list.get(temp).get(i)]) { // 아직 방문 x
					visited[list.get(temp).get(i)]=true;
					queue.add(list.get(temp).get(i));
					depth[list.get(temp).get(i)]=depth[temp]+1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		visited=new boolean[n+1];
		depth=new int[n+1];
		search(1);
		
		int max=0;
		int max_num=0;
		for(int i=1; i<=n; i++) {
			if(max<depth[i]) {
				max=depth[i];
				max_num=i;
			}
		}
		
		int cnt=0;
		for(int i=1; i<=n; i++) {
			if(depth[max_num]==depth[i]) {
				cnt+=1;
			}
		}
		System.out.println(max_num+" "+max+" "+cnt);
	}
}
