package fifteenth;

/* 두 용액 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 양수 : 알칼리성
        // 음수 : 산성
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int start = 0, end = n - 1;             // pointer
        int limit = 0, min = Integer.MAX_VALUE;
        int ansA = 0, ansB = 0;                 // answer

        while(start < end){
            int sum = nums[start] + nums[end];
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                ansA = nums[start];
                ansB = nums[end];
            }
            if(sum < limit) start++;
            else            end--;
        }

        System.out.println(ansA + " " + ansB);
    }
}
