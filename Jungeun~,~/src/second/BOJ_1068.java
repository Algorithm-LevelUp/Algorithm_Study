package second;

/*
 * 트리
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1068 {
	private static boolean[] visited;
	private static int[] tree;
	private static int n, total = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 노드의 개수
		n = Integer.parseInt(br.readLine());
		
		// 방문 배열
		visited = new boolean[n];
		tree = new int[n];
		int root = 0;
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int node = Integer.parseInt(st.nextToken());
			// 루트
			if(node == -1) root = i;
			// 인덱스가 노드 번호
			tree[i] = node;
		}
		
		// 삭제할 노드 번호
		int index = Integer.parseInt(br.readLine());
		delete(index);
		leaf(root);
		
		System.out.println(total);
	}
	
	// idx 부터 삭제
	private static void delete(int idx) {
		// 삭제한 노드는 -2로 저장 (노드의 값이 -1부터 양수까지이므로)
		tree[idx] = -2;
		for(int i = 0; i < n; i++) {
			// 자식 노드도 삭제 진행
			if(tree[i] == idx)	delete(i);
		}
	}
	
	// leaf node 개수 세기
	private static void leaf(int x) {
		boolean isLeaf = true;
		visited[x] = true;
		if(tree[x] == -2)	return;
		for(int i = 0; i < n; i++) {
			// 자식이 있는 경우
			if(tree[i] == x && !visited[i]) {
				leaf(i);
				isLeaf = false;
			}
		}
		
		if(isLeaf) total++;
	}

}
