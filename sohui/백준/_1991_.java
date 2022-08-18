import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1991_ { // 트리 순회
	static List<List<Integer>> list;
	static List<Character> answer;
	
	static void preorder(int start) { // 전위
		answer.add((char)(start+65));
		if(list.get(start).get(0)!=-1) {
			preorder(list.get(start).get(0));
		}
		if(list.get(start).get(1)!=-1) {
			preorder(list.get(start).get(1));
		}
	}
	
	static void inorder(int start) { //중위
		if(list.get(start).get(0)!=-1) {
			inorder(list.get(start).get(0));
		}
		answer.add((char)(start+65));
		if(list.get(start).get(1)!=-1) {
			inorder(list.get(start).get(1));
		}
	}
	
	static void postorder(int start) { //후위
		if(list.get(start).get(0)!=-1) {
			postorder(list.get(start).get(0));
		}
		if(list.get(start).get(1)!=-1) {
			postorder(list.get(start).get(1));
		}
		answer.add((char)(start+65));
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int node = st.nextToken().charAt(0) - 65;
			int left_node = st.nextToken().charAt(0) - 65;
			if(left_node <0) {
				left_node=-1;
			}
			int right_node = st.nextToken().charAt(0) - 65;
			if(right_node<0) {
				right_node=-1;
			}
			list.get(node).add(left_node);
			list.get(node).add(right_node);
		}
		
		answer=new ArrayList<>();
		preorder(0);
		for(char x:answer) {
			System.out.print(x);
		}
		System.out.println();
		
		answer=new ArrayList<>();
		inorder(0);
		for(char x:answer) {
			System.out.print(x);
		}
		System.out.println();
		
		answer=new ArrayList<>();
		postorder(0);
		for(char x:answer) {
			System.out.print(x);
		}
		System.out.println();
		
	}
}