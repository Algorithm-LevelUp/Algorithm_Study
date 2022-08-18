import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1541_ { // 잃어버린 괄호
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer>list=new ArrayList<>();
		
		String s=bf.readLine();
		String[] minus_split=s.split("-");
		
		for(int i=0; i<minus_split.length; i++) {
			if(minus_split[i].contains("+")) {
				String[] plus_split=minus_split[i].split("\\+");
				int section_sum=0;
				for(int j=0; j<plus_split.length; j++) {
					section_sum+=Integer.parseInt(plus_split[j]);
				}
				list.add(section_sum);
			}else {
				list.add(Integer.parseInt(minus_split[i]));
			}
		}
		int answer=list.get(0);
		for(int i=1; i<list.size(); i++) {
			answer-=list.get(i);
		}
		System.out.println(answer);
	}
}
