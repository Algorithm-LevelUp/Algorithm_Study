package fifteenth;

/* 두 수의 합 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int x = Integer.parseInt(br.readLine());    // 만족하는 조건

        int cnt = 0;
        int start = 0, end = n - 1;

        while(start < end){
            int sum = nums[start] + nums[end];
            if(sum >= x)    end--;
            else            start++;

            if(sum == x)    cnt++;
        }

        System.out.println(cnt);
    }
}
