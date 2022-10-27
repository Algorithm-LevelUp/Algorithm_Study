package twelveth;

/* 가장 긴 바이토닉 부분 수열 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11054 {
    private static int[] num;
    private static int[] lis, lds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        num = new int[n];
        lis = new int[n];
        lds = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            num[i]  = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for(int i = 0; i < n; i++){
            // 증가할 때
            for(int j = 0; j < i; j++){
                if(num[i] > num[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        for(int i = n - 1; i > -1; i--){
            for(int j = n - 1; j > i; j--){
                if(num[i] > num[j]){
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            int cnt = lis[i] + lds[i];
            max = Math.max(max, cnt);
//            System.out.println(lis[i] + " " + lds[i] + " " + cnt);
        }

        System.out.println(max - 1);
    }


}
