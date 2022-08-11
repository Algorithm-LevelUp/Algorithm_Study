import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _5639_ { // 이진 검색 트리
	static List<int[]> list;
	static int idx=1;
	static List<Integer> answer;
	
	static void search(int start, int insert) {
		if (list.get(start)[0] > insert) {
			if (list.get(start)[1] == -1) { // 왼쪽 노드 빔
				list.add(new int[] { insert, -1, -1 });
				list.get(start)[1] = idx;
				idx++;
			} else {
				search(list.get(start)[1], insert);
			}
		} else {
			if (list.get(start)[2] == -1) { // 오른쪽 노드 빔
				list.add(new int[] { insert, -1, -1 });
				list.get(start)[2] = idx;
				idx++;
			} else {
				search(list.get(start)[2], insert);
			}
		}
	}
	
	static void postorder(int start) { // 후위 순회
		if(list.get(start)[1]!=-1) {
			postorder(list.get(start)[1]);
		}
		if(list.get(start)[2]!=-1) {
			postorder(list.get(start)[2]);
		}
		answer.add(start);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		list =new ArrayList<>(); 
		
		int[]arr= {Integer.parseInt(bf.readLine()), -1,-1};
		list.add(arr); //루트
		
		String check="";
		while((check=bf.readLine())!=null) {
			search(0, Integer.parseInt(check));
		}
		
		postorder(0);
		for(int x: answer) {
			System.out.println(x);
		}
	}
}
