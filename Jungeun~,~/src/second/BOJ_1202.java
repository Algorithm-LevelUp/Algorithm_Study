package second;

/*
 * 보석 도둑
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 보석의 총 개수
		int n = Integer.parseInt(st.nextToken());
		// 가방 개수
		int k = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> list = new PriorityQueue<>((x, y) -> {
			// 무게가 같을 때 가격 내림차순
			if(x[0] == y[0])	return y[1] - x[1];
			// 무게 오름차순
			return x[0] - y[0];
		}) ;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// 무게
			int m = Integer.parseInt(st.nextToken());
			// 가격
			int v = Integer.parseInt(st.nextToken());
			list.add(new int[] {m, v});
		}
		
		// 최대 무게
		int[] weights = new int[k];
		for(int i = 0; i < k; i++) {
			weights[i] = Integer.parseInt(br.readLine());
		}
		// 오름차순
		Arrays.sort(weights);
		
		long total = 0;
		// 가격 내림차순으로 정렬
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0; i < k; i++) {
			int w = weights[i];
			while(!list.isEmpty()) {
				// 최대 무게보다 보석의 무게가 더 큰 경우
				if(list.peek()[0] > w)	break;
				q.add(list.poll()[1]);
			}
			
			// 최대 무게 안쪽일 때 제일 큰 값 더하기
			if(!q.isEmpty())	total += q.poll();
		}
		
		System.out.println(total);
	}

}
