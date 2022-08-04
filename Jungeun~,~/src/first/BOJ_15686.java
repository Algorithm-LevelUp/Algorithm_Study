package gold;

/*
 * 치킨 배달
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {
    // 집 위치 리스트
    private static List<int[]> house = new ArrayList<>();
    // 치킨집 위치 리스트
    private static List<int[]> chicken = new ArrayList<>();
    private static int n, m, min = Integer.MAX_VALUE;
    // 방문 배열
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 크기
        int n = Integer.parseInt(st.nextToken());
        // 치킨집의 최대 개수
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][n + 1];

        // 0 = 빈칸, 1 = 집, 2 = 치킨집
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) house.add(new int[]{i, j});
                else if (map[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }
        visited = new boolean[chicken.size()];
        distance(0, 0);
        System.out.println(min);
    }

    private static void distance(int cnt, int start){
        // 최대 m개의 치킨집
        if(cnt == m){
            int total = 0;
            for(int i = 0; i < house.size(); i++){
                int sum = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++){
                    if(visited[j]){
                        int dist = Math.abs(house.get(i)[0] - chicken.get(j)[0]) + Math.abs(house.get(i)[1] - chicken.get(j)[1]);
                        sum = Math.min(sum, dist);
                    }
                }
                total += sum;
            }
            min = Math.min(total, min);
            return;
        }

        for(int i = start; i < chicken.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                distance(cnt + 1,i + 1);
                visited[i] = false;
            }
        }
    }

}
