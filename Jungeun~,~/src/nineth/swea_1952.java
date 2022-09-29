package nineth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 수영장 */

public class swea_1952 {
    private static int min;
    private static int[] fees, plans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 1일 이용권, 1달 이용권, 3달 이용권, 1년 이용권
            fees = new int[4];
            for(int i = 0; i < 4; i++){
                fees[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            // 12개월 계획
            plans = new int[12];
            for(int i = 0; i < 12; i++){
                plans[i] = Integer.parseInt(st.nextToken());
            }

            // 1년치 요금을 min으로 둠
            min = fees[3];
            dfs(0, 0);
            System.out.println("#"+tc+" "+min);
        }
    }

    private static void dfs(int cnt, int sum){
        if(cnt >= 12){
            min = Math.min(min, sum);
            return;
        }

        dfs(cnt + 1, sum + plans[cnt] * fees[0]);   // 1day
        dfs(cnt + 1, sum + fees[1]);    // 1month
        dfs(cnt + 3, sum + fees[2]);    // 3months

    }
}
