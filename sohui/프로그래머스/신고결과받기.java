import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {
	 public int[] solution(String[] id_list, String[] report, int k) {
	        int[] answer = new int[id_list.length];
	        
	        HashMap<String, Integer> result=new HashMap<>();
	        HashMap<String,HashSet<String>> map=new HashMap<>();
	        for(int i=0; i<id_list.length; i++) {
	        	map.put(id_list[i], new HashSet<>());
	        	result.put(id_list[i], 0);
	        }
	        for(int i=0; i<report.length; i++) {
	        	String[] person=report[i].split(" ");
	        	HashSet<String> set=map.get(person[1]);
	        	set.add(person[0]);
	        }
	        for(int i=0; i<id_list.length; i++) {
	        	if(map.get(id_list[i]).size() >=k) {
	        		for(String x: map.get(id_list[i])) {
	        			result.put(x, result.get(x)+1);
	        		}
	        	}
	        }
	        for(int i=0; i<id_list.length; i++) {
	        	answer[i]=result.get(id_list[i]);
	        }
	        
	        return answer;
 }
}
