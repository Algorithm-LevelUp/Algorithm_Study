import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class _2382_ {
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static HashMap<Integer, Info>list;
	static HashMap<Integer, List<Integer>> move;
	static List<Integer>del;
	static int m,n;
	
	public static void main(String args[]) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T=Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st=new StringTokenizer(bf.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken()); 
			int k=Integer.parseInt(st.nextToken()); 
		
			list=new HashMap<>();
			
			int idx=1;
			for(int i=0; i<k; i++) { // input
				int[]arr=new int [4];
				st=new StringTokenizer(bf.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int cnt=Integer.parseInt(st.nextToken());
				int d=Integer.parseInt(st.nextToken());
				list.put(idx++, new Info(x, y, cnt, d));
			}
			search();
			int result=0;
			for(Integer j: list.keySet()) {
				result+=list.get(j).cnt;
			}
			System.out.println("#"+test_case+" "+result);
		}
	}

	private static void search() {
		for(int i=0; i<m; i++) {
			int[][]newMap=new int[n][n];
			move=new HashMap<>();
			del=new ArrayList<>();
			for(int j: list.keySet()) {
				Info info=list.get(j);
				info.x+=dx[info.d-1];
				info.y+=dy[info.d-1];
				if(info.x==0 || info.y==0 || info.x==n-1 || info.y==n-1) { 
					if(info.cnt/2==0) {
						del.add(j);
					}else {
						info.cnt/=2;
						if(info.d==1) info.d=2;
						else if(info.d==2) info.d=1;
						else if(info.d==3) info.d=4;
						else if(info.d==4) info.d=3;
					}
				}
				list.put(j, info); // update
				if(newMap[info.x][info.y]>0) { 
					int idx=newMap[info.x][info.y];
					if(move.containsKey(idx)) {
						move.get(idx).add(j);
					}else {
						move.put(idx, new ArrayList<>());
						move.get(idx).add(idx);
						move.get(idx).add(j);
					}
				}else {
					newMap[info.x][info.y]=j;
				}
			}
			for(int key: move.keySet()) {
				List<Integer>temp=move.get(key);
				int num_idx=temp.get(0);
				int num=list.get(num_idx).cnt;
				int num_d=list.get(num_idx).d;
				
				for(int k=1; k<temp.size(); k++) {
					if(num<list.get(temp.get(k)).cnt) {
						num=list.get(temp.get(k)).cnt;
						del.add(num_idx);
						list.get(temp.get(k)).cnt+=list.get(num_idx).cnt;
						num_idx=temp.get(k);
						num_d=list.get(temp.get(k)).d;
					}else {
						list.get(num_idx).cnt+=list.get(temp.get(k)).cnt;
						del.add(temp.get(k));
					}
				}
			}
			for(int k=0; k<del.size(); k++) {
				list.remove(del.get(k));
			}
		}
	}
	static class Info{
		int x,y, cnt, d;

		public Info(int x, int y, int cnt, int d) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.d = d;
		}
	}
}