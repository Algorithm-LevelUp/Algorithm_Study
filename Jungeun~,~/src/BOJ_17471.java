

/* 게리멘더링 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17471 {
    private static int[] people;
    private static List[] map;
    private static boolean[] visited;
    private static int N, min = Integer.MAX_VALUE, total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            people[i] = Integer.parseInt(st.nextToken());
            total += people[i];
        }
        // Initialize
        map = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            map[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());   // 인접한 구역의 수
            while(st.hasMoreTokens()){
                int y = Integer.parseInt(st.nextToken());
                map[i].add(y);
            }
        }

        visited = new boolean[N + 1];
        divide(1, 0);

        if(min == Integer.MAX_VALUE)    min = -1;
        System.out.println(min);
    }

    // 인구 나누기
    private static void divide(int start, int cnt){
        if(cnt > 0 && cnt <= N / 2){
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            for(int i = 1; i <= N; i++){
                if(visited[i])  listA.add(i);
                else            listB.add(i);
            }
            if(connection(listA) && connection(listB)) {
                min = Math.min(min, calculate());
            }
        }

        for(int i = start; i <= N; i++) {
            visited[i] = true;
            divide(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    // 연결되어있는지 확인
    private static boolean connection(List<Integer> list){
        boolean[] check = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(list.get(0));
        check[list.get(0)] = true;

        int cnt = 0;
        while(!q.isEmpty()){
            int x = q.poll();

            for(int i = 0; i < map[x].size(); i++){
                int nx = (int) map[x].get(i);
                if(!check[nx] && list.contains(nx)){
                    cnt++;
                    check[nx] = true;
                    q.add(nx);
                }
            }
        }

        if(cnt != list.size() - 1)  return false;
        return true;
    }

    // 인구 수 계산
    private static int calculate(){
        int result = 0;
        for(int i = 1; i <= N; i++){
            if(visited[i])  result += people[i - 1];
        }
        return Math.abs((total-result) - result);
    }
}
