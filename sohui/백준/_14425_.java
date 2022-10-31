import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _14425_ { // 문자열 집합

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		HashSet<String> set=new HashSet<>();
		for(int i=0; i<n; i++) {
			set.add(bf.readLine());
		}
		
		int cnt=0;
		for(int i=0; i<m; i++) {
			if(set.contains(bf.readLine()))cnt+=1;
		}
		System.out.println(cnt);
	}
}
