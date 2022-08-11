import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1744_ { // 수 묶기
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader( System.in));
		
		int n=Integer.parseInt(bf.readLine());
		
		List<Integer>positive_num=new ArrayList<>(); //양수    
		List<Integer>negative_num=new ArrayList<>(); //음수
		
		for(int i=0; i<n; i++) {
			int num=Integer.parseInt(bf.readLine());
			if(num<=0) {
				negative_num.add(num);
			}else {
				positive_num.add(num);
			}
		}
		Collections.sort(positive_num);
		Collections.reverse(positive_num);
		
		Collections.sort(negative_num);
		
		int answer=0;
		for(int i=0; i<positive_num.size(); i+=2) {
			if(i+1<positive_num.size()) {
				if(positive_num.get(i)!=1 && positive_num.get(i+1)!=1) {
					answer+=(positive_num.get(i)*positive_num.get(i+1));
				}else {
					answer+=(positive_num.get(i)+positive_num.get(i+1));
				}
				
			}else {
				answer+=positive_num.get(i);
			}
		}
		for(int i=0; i<negative_num.size(); i+=2) {
			if(i+1<negative_num.size()) {
				answer+=(negative_num.get(i)*negative_num.get(i+1));
			}else {
				answer+=negative_num.get(i);
			}
		}
		System.out.println(answer);
	}
}
