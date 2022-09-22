package eighth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_kakao_prime {
    private static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        // number
        n = Integer.parseInt(br.readLine());
        // 진수
        k = Integer.parseInt(br.readLine());

        String kNum = k==10 ? String.valueOf(n) : toKnum(n, k);

        int i = 0, j = 0;
        for(i = 0; i < kNum.length(); i = j){
            for(j = i + 1; j < kNum.length() && kNum.charAt(j) != '0'; j++);
            if (isPrime(Long.parseLong(kNum.substring(i, j))))
                answer++;
        }
        System.out.println(answer);
    }
    // k진수로 바꾸기
    private static String toKnum(int n, int k){
        String number = "";
        while(n > 0){
            number = n % k + number;
            n /= k;
        }
        return number;
    }
    // check prime
    private static boolean isPrime(long n){
        if(n <= 1)  return false;
        if(n == 2)  return true;
        for(int i = 3; i <= Math.sqrt(n); i++){
            if(n % i == 0)  return false;
        }
        return true;
    }
}