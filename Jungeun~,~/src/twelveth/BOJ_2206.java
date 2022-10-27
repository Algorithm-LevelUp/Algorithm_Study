package twelveth;

/* 벽 부수고 이동하기 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    private static int[][] map;
    private static boolean[][][] visited;
    private static int N, M;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());	//가로
        M = Integer.parseInt(st.nextToken());	//세로
        map = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j + 1] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[N + 1][M + 1][2];
        bfs(1, 1);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y, 1, 0});
        map[x][y] = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int cnt = now[2];
            int destroy = now[3];

            if(nowX == N && nowY == M) {
                System.out.println(cnt);
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(nextX < 1 || nextY < 1 || nextX > N || nextY > M)	continue;

                if(map[nextX][nextY] == 0) {
                    // 부신 벽이 없으면
                    if(destroy == 0 && !visited[nextX][nextY][0]){
                        q.add(new int[] {nextX, nextY, cnt + 1, 0});
                        visited[nextX][nextY][0] = true;
                    }
                    // 부신 벽이 있으면
                    else if(destroy == 1 && !visited[nextX][nextY][1]) {
                        q.add(new int[] {nextX, nextY, cnt + 1, 1});
                        visited[nextX][nextY][1] = true;
                    }
                }
                // 벽이면
                else if(map[nextX][nextY] == 1){
                    if(destroy == 0){
                        q.add(new int[] {nextX, nextY, cnt + 1, 1});
                        visited[nextX][nextY][1] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }

}