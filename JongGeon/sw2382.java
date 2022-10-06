import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

class Micro{
	Long size;
	int x;
	int y;
	int dir;
	final int dx[] = {-1,1,0,0};
	final int dy[] = {0,0,-1,1};
	Micro(int a,int b,int c ,int d){
		this.x =a;
		this.y =b;
		this.size = (long)c;
		this.dir = d;
	}
	
	int[] move() {
		int[] temp = new int[2];
		this.x += dx[dir-1];
		this.y += dy[dir-1];
		temp[0]=this.x;
		temp[1]=this.y;
		return temp;
	}
	
	void turn() {
		this.size/=2;
		switch(dir) {
		case 1:
			dir = 2;
			break;
		case 2:
			dir =1;
			break;
		case 3:
			dir = 4;
			break;
		case 4:
			dir = 3;
			break;
		}
	}
}

public class sw2382{
	static int n,m,k;
	static Micro []micro;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t<=test; t++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			micro = new Micro[k];
			for(int i=0; i<k; i++) {
				int a,b,c,d;
				str = br.readLine();
				st = new StringTokenizer(str);
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				c=Integer.parseInt(st.nextToken());
				d=Integer.parseInt(st.nextToken());
				
				micro[i]= new Micro(a,b,c,d);
			}
			for(int i=0; i<m; i++) {
				sol();
			}
			Long sum=(long)0;
			for(int i=0; i<k; i++) {
				sum += micro[i].size;
			}
			
			System.out.println("#" + t + " " + sum);
		}
		
	}
	static void sol() {
		Map<String, List<Integer>> map = new HashMap<>();
		for(int i=0; i<k; i++) {
			if(micro[i].size == 0) continue;
			int temp[] = micro[i].move();
			int nx = temp[0];
			int ny = temp[1];
			
			if(nx ==0 || ny ==0 || nx==n-1 || ny == n-1) {
				micro[i].turn();
			}
			
			StringBuilder sb = new StringBuilder("");
			sb.append(nx+" "); sb.append(ny);
			String str = sb.toString();
			
			if(!map.containsKey(str)) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(i);
				map.put(str, l);
			}else {
				map.get(str).add(i);
			}
		}
		
		map.keySet().forEach(e -> {
			if(map.get(e).size()!=1) {
				merge(map.get(e));
			}
		});
	}
	
	static void merge(List<Integer> list) {
		Long big = (long)0;
		int temp= -1;
		Long sum= (long)0;
		for(int i=0; i<list.size(); i++) {
			int idx = list.get(i);
			sum+= micro[idx].size;
			if(micro[idx].size > big) {
				big = micro[idx].size;
				temp = idx;
			}
			micro[idx].size=(long)0;
		}
		micro[temp].size=sum;
	}
}