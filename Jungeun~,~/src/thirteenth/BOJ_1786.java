package thirteenth;

/* 찾기 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1786 {

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();

        kmp(T, P);
    }

    private static void kmp(String T, String P) {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        int[] pi = findPattern(P);

        int tSize = T.length();     // 텍스트 길이
        int pSize = P.length();     // 찾으려는 패턴 길이
        int j = 0;

        for(int i = 0; i < tSize; i++){
            while(j > 0 && T.charAt(i) != P.charAt(j)){
                j = pi[j - 1];
            }

            if(T.charAt(i) == P.charAt(j)){
                if(j == pSize - 1){     // 비교할 문자의 끝까지 다 비교했다면
                    cnt++;
                    list.add(i - pSize + 1);    // 찾은 문자열의 첫 인덱스
                    j = pi[j];              // 문자의 끝부분과 같은 지점으로 이동
                } else j++;
            }
        }

        System.out.println(cnt);
        for(int idx : list){
            System.out.print((idx + 1) + " " );
        }
    }

    // 비교할 문자 패턴 확인
    private static int[] findPattern(String P) {
        int size = P.length();      // 문자의 사이즈
        int[] pi = new int[size];   // Pattern Index

        int j = 0;
        for(int i = 1; i < size; i++){
            while(j > 0 && P.charAt(i) != P.charAt(j)){
                j = pi[j - 1];  // 전 인덱스에 넣었던 값으로 바꿔주기
            }

            if(P.charAt(i) == P.charAt(j)){ // i번째와 j번째가 같으면
                pi[i] = ++j;
            }
        }

        return pi;
    }
}
