import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11725_ { //트리의 부모 찾기
	static List<List<Integer>> list;
	static boolean visited[];
	static int[]arr;

	static void search(int start) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int temp=queue.poll();
			for (int i = 0; i < list.get(temp).size(); i++) {
				if (visited[list.get(temp).get(i)] == false) {
					visited[list.get(temp).get(i)]=true;
					queue.add(list.get(temp).get(i));
					arr[list.get(temp).get(i)-1]=temp;
				}

			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		list = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}

		visited = new boolean[n+1];
		arr=new int[n];
		search(1);
		
		for(int i=1; i<n; i++) {
			System.out.println(arr[i]);
		}

	}

}