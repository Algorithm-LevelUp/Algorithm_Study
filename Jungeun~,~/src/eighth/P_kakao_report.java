package eighth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_kakao_report {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] id_list = br.readLine().split(" ");
        String[]  report = br.readLine().split(",");
        int k = Integer.parseInt(br.readLine());

        Map<String, Integer> reportUser = new HashMap<>();
        Map<String, List<String>> user = new HashMap<>();

        // 초기화
        for(String person: id_list){
            user.put(person, new ArrayList<>());
        }

        for(String idx : report){
            boolean flag = false;
            // 신고한 사람
            String reportedPerson = idx.split(" ")[0];
            // 신고당한 사람
            String reportingPerson = idx.split(" ")[1];

            // 신고 리스트
            if(user.containsKey(reportedPerson)){
                List<String> list = user.get(reportedPerson);
                if(list.contains(reportingPerson)) {
                    flag = true;
                    continue;
                }
                list.add(reportingPerson);
                user.put(reportedPerson, list);
            }

            // 신고당한 횟수
            if(flag)    continue;
            if(reportUser.containsKey(reportingPerson)){
                reportUser.put(reportingPerson, reportUser.get(reportingPerson) + 1);
            }else{
                reportUser.put(reportingPerson, 1);
            }
        }

        int[] answer = new int[id_list.length];

        for(String key : id_list){
            if(!reportUser.containsKey(key))    continue;
            int number = reportUser.get(key);
            if(number < k)  reportUser.remove(key);
        }

        int idx = 0;
        for (String key : id_list) {
            if (!user.containsKey(key)) continue;
            List<String> list = user.get(key);
            for (String u : list) {
                if (reportUser.containsKey(u)) answer[idx]++;
            }
            idx++;
        }

        System.out.println(Arrays.toString(answer));
    }
}