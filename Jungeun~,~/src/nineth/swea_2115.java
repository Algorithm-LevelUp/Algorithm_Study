package nineth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2115 {
    private static int n, m, c, value, max;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   // 벌통의 크기
            m = Integer.parseInt(st.nextToken());   // 선택할 수 있는 벌통의 개수
            c = Integer.parseInt(st.nextToken());   // 채취할 수 있는 꿀의 양

            map = new int[n][n];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[n][n];
            // initialize
            value = 0; max = 0;
            select();
            System.out.println("#"+tc+" "+value);
        }
    }

    private static void select(){
        int max1 = 0;   // person 1
        int max2 = 0;   // person 2
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= n - m; j++){
                // 일꾼 1의 이익
                max = 0;
                money(i, j, 0, 0, 0);
                max1 = max;

                // 일꾼 2의 이익
                max = 0;
                max2 = 0;
                for(int y = j + m; y <= n - m; y++){
                    money(i, y, 0, 0, 0);
                    max2 = Math.max(max2, max);
                }

                for(int x = i + 1; x < n; x++){
                    for(int y = 0; y <= n - m; y++){
                        money(x, y, 0, 0, 0);
                        max2 = Math.max(max2, max);
                    }
                }
                value = Math.max(value, max1 + max2);
            }
        }
    }

    private static void money(int x, int y, int cnt, int total, int profit){
        // 채취해야할 양을 넘긴 경우
        if(total > c)   return;
        // 벌꿀을 m만큼 선택했을 경우
        if(cnt == m){
            max = Math.max(max, profit);
            return;
        }

        money(x, y + 1, cnt + 1, total + map[x][y], profit + map[x][y] * map[x][y]);
        money(x, y + 1, cnt + 1, total,  profit);
    }
}
