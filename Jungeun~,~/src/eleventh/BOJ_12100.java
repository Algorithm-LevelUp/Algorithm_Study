package eleventh;

/* 2048(Easy) */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12100 {
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    private static int[] dy = {0, 0, -1, 1};
    private static int n, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move(0);
        System.out.println(max);
    }

    private static void move(int cnt){
        if(cnt == 5){
            int m = 0;
            // 최댓값 계산
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    m = Math.max(m, map[i][j]);
                }
            }
            max = Math.max(max, m);
            return;
        }

        for(int dir = 0; dir < 4; dir++){
            int[][] copy = copyArr();
            combine(dir);
//            System.out.println(dir);
//            print();
            move(cnt + 1);
            map = copy;
        }
    }

    private static void print(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void combine(int dir){
        switch (dir){
            case 0:
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n - 1; j++){
                        if(map[j][i] == 0)  continue;
                        for(int x = j + 1; x < n; x++){
                            if(map[x][i] != 0){
                                if(map[x][i] != map[j][i])  break;
                                map[j][i] += map[x][i];
                                map[x][i] = 0;
                                j = x;
                                break;
                            }
                        }
                    }
                    for(int j = 0; j < n - 1; j++) {
                        if (map[j][i] != 0) continue;
                        for(int x = j + 1; x < n; x++){
                            if(map[x][i] != 0) {
                                map[j][i] = map[x][i];
                                map[x][i] = 0;
                                break;
                            }
                        }
                    }
                }
                return;
            case 1:
                for(int i = 0; i < n; i++){
                    for(int j = n - 1; j > 0; j--){
                        if (map[j][i] == 0) continue;
                        for(int x = j - 1; x > -1; x--){
                            if(map[x][i] != 0) {
                                if(map[x][i] != map[j][i])  break;
                                map[j][i] += map[x][i];
                                map[x][i] = 0;
                                break;
                            }
                        }
                    }
                    for(int j = n - 1; j > 0; j--) {
                        if (map[j][i] != 0) continue;
                        for(int x = j - 1; x > -1; x--){
                            if(map[x][i] != 0) {
                                map[j][i] = map[x][i];
                                map[x][i] = 0;
                                break;
                            }
                        }
                    }
                }
                return;
            case 2:
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n - 1; j++){
                        if(map[i][j] == 0)  continue;
                        for(int x = j + 1; x < n; x++) {
                            if(map[i][x] != 0) {
                                if(map[i][x] != map[i][j])  break;
                                map[i][j] += map[i][x];
                                map[i][x] = 0;
                                break;
                            }
                        }
                    }
                    for(int j = 0; j < n - 1; j++) {
                        if (map[i][j] != 0) continue;
                        for(int x = j + 1; x < n; x++) {
                            if(map[i][x] != 0) {
                                map[i][j] = map[i][x];
                                map[i][x] = 0;
                                break;
                            }
                        }
                    }
                }
                return;
            case 3:
                for(int i = 0; i < n; i++){
                    for(int j = n - 1; j > 0; j--){
                        if (map[i][j] == 0) continue;
                        for(int x = j - 1; x > -1; x--) {
                            if(map[i][x] != 0) {
                                if(map[i][x] != map[i][j])  break;
                                map[i][j] += map[i][x];
                                map[i][x] = 0;
                                break;
                            }
                        }
                    }
                    for(int j = n - 1; j > 0; j--) {
                        if (map[i][j] != 0) continue;
                        for(int x = j - 1; x > -1; x--) {
                            if(map[i][x] != 0) {
                                map[i][j] = map[i][x];
                                map[i][x] = 0;
                                break;
                            }
                        }
                    }
                }
                return;
        }
    }

    private static int[][] copyArr(){
        int[][] copy = new int[n][n];
        for(int i = 0; i < n; i++){
            copy[i] = Arrays.copyOf(map[i], n);
        }
        return copy;
    }
}
