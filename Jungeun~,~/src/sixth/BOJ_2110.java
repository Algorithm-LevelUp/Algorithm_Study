package sixth;
/*
 * 공유기 설치
 * 이분 탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// x의 좌표
		int N = Integer.parseInt(st.nextToken());
		// 공유기
		int C = Integer.parseInt(st.nextToken());
		int[] wifi = new int[N];
		
		for(int i = 0; i < N; i++) {
			wifi[i] = Integer.parseInt(br.readLine());
		}
		// 정렬
		Arrays.sort(wifi);
		int answer = 0;
		
		int left = 1;		//min
		int right = wifi[N - 1] - wifi[0];	//max
		while(left <= right) {
			// 중간
			int mid  = (left + right) / 2;
			int prev = wifi[0];
			int cnt = 1;
			for(int i = 1; i < N; i++) {
				
				// 현재 탐색하는 위치와 직전에 설치했던 위치의 거리 계산
				int dis = wifi[i] - prev;
				// 중간값보다 거리가 멀 때
				if(dis >= mid) {
					cnt++;
					prev = wifi[i];
				}
			}
			
			if(cnt >= C) {
				left = mid + 1;
				answer = mid;
			}
			else	right = mid - 1;
		}
		
		System.out.println(answer);
	}
	

}
