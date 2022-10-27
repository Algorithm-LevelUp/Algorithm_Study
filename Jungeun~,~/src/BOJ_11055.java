package silver;

/* 가장 큰 증가 부분 수열 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = num[0];
        for(int i = 1; i < n; i++){
            dp[i] = num[i];
            for(int j = 0; j < i; j++){
                if(num[i] > num[j]){
                    dp[i] = Math.max(dp[i], dp[j] + num[i]);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
