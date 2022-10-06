package swa;

/* 숫자 만들기 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4008 {
    private static int[] operator, numbers;
    private static int n;
    private static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            // 숫자의 개수
            n = Integer.parseInt(br.readLine());
            // 연산자
            operator = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++){
                operator[i] = Integer.parseInt(st.nextToken());
            }
            // 숫자
            numbers = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            search(1, numbers[0]);

            System.out.println("#"+tc+" "+(max - min));
        }
    }

    private static void search(int cnt, int sum){
        if(cnt == n){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        if(operator[0] > 0) {
            operator[0]--;
            search(cnt + 1, sum + numbers[cnt]);
            operator[0]++;
        }

        if(operator[1] > 0) {
            operator[1]--;
            search(cnt + 1, sum - numbers[cnt]);
            operator[1]++;
        }

        if(operator[2] > 0) {
            operator[2]--;
            search(cnt + 1, sum * numbers[cnt]);
            operator[2]++;
        }

        if(operator[3] > 0) {
            operator[3]--;
            search(cnt + 1, sum / numbers[cnt]);
            operator[3]++;
        }
    }
}
