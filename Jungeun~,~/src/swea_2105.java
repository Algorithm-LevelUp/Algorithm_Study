package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_2105 {
    private static int[][] map;
    private static boolean[] check;
    private static int[] dx = {1, -1, -1, 1};
    private static int[] dy = {1, 1, -1, -1};
    private static int n, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            max = -1;

            map = new int[n][n];
            int maximum = 0;
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maximum = Math.max(maximum, map[i][j]);
                }
            }

            check = new boolean[maximum + 1];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    dfs(i, j, i, j, 0, 0);
                }
            }

            System.out.println("#" + tc +" " + max);
        }
    }

    private static void dfs(int startX, int startY, int x, int y, int cnt, int dir){
        if(check[map[x][y]] && x == startX && y == startY){
            max = Math.max(max, cnt);
            return;
        }

        for(int i = dir; i <= dir + 1; i++){
            if(i > 3)   break;
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n)  continue;
            if(check[map[nx][ny]])  continue;

            check[map[nx][ny]] = true;
            dfs(startX, startY, nx, ny, cnt + 1, i);
            check[map[nx][ny]] = false;
        }
    }
}
