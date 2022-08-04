package gold;

/*
 * 알파벳
 * 백트래킹
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
	private static boolean[] capitals = new boolean[26];
	private static char[][] board;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int cnt = 0, r, c;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		board = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		alpha(0, 0, 0);
		System.out.println(cnt);
	}
	
	private static void alpha(int x, int y, int total) {
		// 종료
		if(capitals[board[x][y] - 'A']) {
			if(total > cnt)		cnt = total;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int index = board[x][y] - 'A';
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			// 범위를 벗어났을 때
			if(nextX < 0 || nextX >= r || nextY < 0 || nextY >= c)	 continue;

			capitals[index] = true;
			alpha(nextX, nextY, total + 1);
			capitals[index] = false;
		}
	}

}
