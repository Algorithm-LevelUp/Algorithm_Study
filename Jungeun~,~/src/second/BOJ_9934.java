package second;

/*
 * 완전 이진 트리
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9934 {
	private static int[] buildings;
	private static int k;
	private static List<Integer>[] nodeList;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		
		// 총 노드의 개수 = 2 ^ k - 1
		buildings = new int[(int)Math.pow(2, k) -1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < buildings.length; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		
		nodeList = new ArrayList[k];
		for(int i = 0; i < k; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		solve(0, buildings.length - 1, 0);
		
		for(int i = 0; i < k; i++) {
			for(Integer value : nodeList[i]) {
				System.out.print(value+" ");
			}
			System.out.println();
		}
		
	}
	
	// s = 시작 위치, len = 마지막 위치, floor = 레벨
	private static void solve(int s, int len, int floor) {
		if(floor == k)	return;
		
		// 중간값
		int mid = (s + len) / 2;
		nodeList[floor].add(buildings[mid]);
		
		solve(s, mid - 1, floor + 1);
		solve(mid + 1, len, floor + 1);
	}

}
