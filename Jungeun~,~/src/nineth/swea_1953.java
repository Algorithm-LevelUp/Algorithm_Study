package nineth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};    // 상 우 하 좌
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] tunnel = {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1},
    };
    private static int n, m, l, cnt;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 지도 크기
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            // 맨홀 뚜껑 위치
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 탈출 후 소요시간
            l = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cnt = 1;
            visited = new boolean[n][m];
            bfs(r, c);
            System.out.println("#"+tc+" "+cnt);
        }
    }

    private static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(new int[] {r, c, 0});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int time = now[2];

            int loc = map[now[0]][now[1]];

            for(int i = 0; i < 4; i++){
                if(tunnel[loc][i] == 0) continue;

                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                // 범위를 벗어났을 경우
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)  continue;
                // 이미 방문한 곳이거나 값이 0일 때
                if(visited[nextX][nextY] || map[nextX][nextY] == 0)   continue;
                // 다음 터널이 이어져있지 않은 경우
                if(tunnel[map[nextX][nextY]][(i + 2) % 4] == 1)  {
                    if(time + 1 >= l)   continue;
                    queue.add(new int[] {nextX, nextY, time + 1});
                    visited[nextX][nextY] = true;
                    cnt++;
                }
            }
            time++;
        }
    }

}
