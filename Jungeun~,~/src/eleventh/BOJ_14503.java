package eleventh;
/* 로봇 청소기 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503 {
    private static int n, m, cnt = 1;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};    // 북 동 남 서
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        move(r, c, d);
        System.out.println(cnt);
    }

    private static void move(int x, int y, int dir){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y, dir});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nd = now[2];

            boolean flag = false;
            for(int i = 0; i < 4; i++){
                nd = (nd + 3) % 4;
                int nx = now[0] + dx[nd];
                int ny = now[1] + dy[nd];


                if(nx < 0 || ny < 0 || nx >= n || ny >= m)  continue;   // 범위를 벗어났을 때
                if(map[nx][ny] == 1 || visited[nx][ny])     continue;
                q.add(new int[] {nx, ny, nd});
                visited[nx][ny] = true;
                cnt++;
                flag = true;
                break;
            }

            // 네 방향을 모두 탐색했지만 청소할 곳을 찾지 못했을 때
            if(!flag){
                int nx = now[0];
                int ny = now[1];
                // 후진하기
                switch (nd){
                    case 0: nx++; break;
                    case 1: ny--; break;
                    case 2: nx--; break;
                    case 3: ny++; break;
                }
                // 뒤쪽도 벽이라서 후진할 수 없으면 종료
                if(map[nx][ny] == 1)    return;
                q.add(new int[] {nx, ny, nd});
            }
        }
    }
}
