import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class _20056_ { // 마법사 상어와 파이어볼
	static List<Ball> list;
	static HashMap<Integer, List<Integer>> multi;
	static List<Integer> del;
	static int N;
	
	static int[] dx= {-1,-1,0,1,1,1,0,-1};
	static int[] dy= {0,1,1,1,0,-1,-1,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken()); 
		int M=Integer.parseInt(st.nextToken()); // 파이어볼
		int K=Integer.parseInt(st.nextToken());
		
		list=new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(bf.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			list.add(new Ball(r-1, c-1, m, s, d));
		}
		
		for(int i=0; i<K; i++) {
			move();
		}
		int answer=0;
		for(int i=0; i<list.size(); i++) {
			answer+=list.get(i).m;
		}
		
		System.out.println(answer);
	}
	
	private static void move() {
		int[][] check=new int[N][N];
		multi=new HashMap<>();
		del=new ArrayList<>();
		
		//이동
		for(int key=0; key<list.size(); key++) {
			Ball ball=list.get(key);
			int x=ball.r+(dx[ball.d]*ball.s);
			int y=ball.c+(dy[ball.d]*ball.s);
			if(x<0) {
				while(x<0) x+=N;
			}else if(x>=N) {
				while(x>=N) x-=N;
			}
			if(y<0) {
				while(y<0) y+=N;
			}else if(y>=N) {
				while(y>=N) y-=N;
			}
			list.get(key).r=x;
			list.get(key).c=y;
			if(check[x][y]==0) check[x][y]=key+1;
			else {
				if(multi.containsKey(check[x][y])) {
					multi.get(check[x][y]).add(key+1);
				}else {
					multi.put(check[x][y], new ArrayList<>());
					multi.get(check[x][y]).add(check[x][y]);
					multi.get(check[x][y]).add(key+1);
				}
			}
		}
		
		for(int key: multi.keySet()) {
			int m_sum=0, s_sum=0;
			boolean flag=true; // 짝수
			boolean ch=true;
			List<Integer> temp=multi.get(key);
			if(list.get(temp.get(0)-1).d %2!=0) { // 홀수
				flag=false;
			}
			for(int num: temp) {
				m_sum+=list.get(num-1).m;
				s_sum+=list.get(num-1).s;
				if(flag==true && list.get(num-1).d %2==0) { // 짝수
					continue;
				}
				if(flag==false && list.get(num-1).d%2==1) { // 홀수
					continue;
				}
				// 모두 짝수나 홀수가 아님
				ch=false;
			}
			for(int num: temp) { 
				del.add(num-1);
			}
			if(m_sum/5 !=0) { 
				int new_m=m_sum/5;
				int new_s=s_sum/temp.size();
				if(ch) { // 모두 짝수 or 홀수
					list.add(new Ball(list.get(temp.get(0)-1).r, list.get(temp.get(0)-1).c, new_m, new_s, 0));
					list.add(new Ball(list.get(temp.get(0)-1).r, list.get(temp.get(0)-1).c, new_m, new_s, 2));
					list.add(new Ball(list.get(temp.get(0)-1).r, list.get(temp.get(0)-1).c, new_m, new_s, 4));
					list.add(new Ball(list.get(temp.get(0)-1).r, list.get(temp.get(0)-1).c, new_m, new_s, 6));
				}else {
					list.add(new Ball(list.get(temp.get(0)-1).r, list.get(temp.get(0)-1).c, new_m, new_s, 1));
					list.add(new Ball(list.get(temp.get(0)-1).r, list.get(temp.get(0)-1).c, new_m, new_s, 3));
					list.add(new Ball(list.get(temp.get(0)-1).r, list.get(temp.get(0)-1).c, new_m, new_s, 5));
					list.add(new Ball(list.get(temp.get(0)-1).r, list.get(temp.get(0)-1).c, new_m, new_s, 7));
				}
				
			}
			
		}
		Collections.sort(del, Collections.reverseOrder());
		for(int j=0; j<del.size(); j++) {
			int index=del.get(j);
			list.remove(index);
		}
	}

	static class Ball{
		int r,c,m,s,d;

		public Ball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
}
