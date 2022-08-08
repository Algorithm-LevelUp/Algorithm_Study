package second;

/*
 * 카드 정렬하기
 * 그리디 알고리즘
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		// 숫자 카드 묶음의 크기 <= 1000
		// 1000 * 100,000 = 1억 => long
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		long num = 0;
		
		while(pq.size() > 1) {
			long tmp1 = pq.poll();
			long tmp2 = pq.poll();
			
			num += tmp1 + tmp2;
			// 합한 묶음을 우선순위 큐에 넣기
			pq.add(tmp1 + tmp2);
		}
		
		System.out.println(num);
	}

}
