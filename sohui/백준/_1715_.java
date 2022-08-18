import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1715_ { // 카드 정렬하기
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> priorityqueue=new PriorityQueue<>(); 
		
		for(int i=0; i<n; i++) {
			priorityqueue.add(Integer.parseInt(bf.readLine()));
		}
		
		int result=0;
		while(priorityqueue.size()>1) {
			int temp=priorityqueue.poll()+priorityqueue.poll();
			result+=temp;
			priorityqueue.add(temp);
		}
		System.out.println(result);
	}
}
