package silver;

/* 2xn 타일링3 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] * 2;
            if(i % 2 == 0)  dp[i]++;
            else            dp[i]--;
            dp[i] %= 10007;
        }

        System.out.println(dp[n]);
    }
}
