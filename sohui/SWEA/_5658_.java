import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class _5658_ {
	public static void main(String args[]) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st=new StringTokenizer(bf.readLine());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
			char[][]arr=new char[4][n/4];
			TreeSet<Integer> tree=new TreeSet<>();
			
			String b=bf.readLine();
			int idx=0;
			for(int i=0; i<4; i++) {
				String temp="";
				for(int j=0; j<n/4; j++) {
					arr[i][j]=b.charAt(idx++);
					temp+=arr[i][j];
				}
				tree.add(Integer.parseInt(temp, 16));
			}
			
			for(int i=0; i<n; i++) {
				char last=arr[3][n/4-1]; // 마지막 값
				for(int j=0; j<4; j++) {
					String a="";
					for(int l=0; l<n/4; l++) {
						char temp=arr[j][l];
						arr[j][l]=last;
						a+=arr[j][l];
						last=temp;
					}
					tree.add(Integer.parseInt(a, 16));
				}
			}
			idx=0;
			int result=0;
			for(int x: tree) {
				if(idx++==tree.size()-k) {
					result=x;
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}