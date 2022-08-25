package fourth;

/*
 * 주사위 굴리기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {
	private static int[][] map;
	private static int[] dx = {0, 0, 0, -1, 1};
	private static int[] dy = {0, 1, -1, 0, 0};
	private static int[] dice = new int[6];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 세로
		int n = Integer.parseInt(st.nextToken());
		// 가로
		int m = Integer.parseInt(st.nextToken());
		// 주사위 좌표
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		// 명령의 개수
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			int c = Integer.parseInt(st.nextToken());
			int nx = x + dx[c];
			int ny = y + dy[c];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= m)	continue;
			dice(c);
			
			// 칸에 복사
			if(map[nx][ny] == 0) {
				map[nx][ny] = dice[1];
			}
			// 주사위에 복사
			else {
				dice[1] = map[nx][ny];
				map[nx][ny] = 0;
			}
			x = nx; y = ny;
			System.out.println(dice[3]);
		}
	}
	
	private static void dice(int c) {
		int temp = 0;
		
		
		switch(c) {
		// 동쪽
		case 1:
			temp = dice[3];
			dice[3] = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[5];
			dice[5] = temp;
			break;
		// 서쪽
		case 2:
			temp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
			break;
		// 북쪽
		case 3:
			temp = dice[3];
			dice[3] = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[0];
			dice[0] = temp;
			break;
		// 남쪽
		case 4:
			temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = temp;
			break;
		}
	}

}

