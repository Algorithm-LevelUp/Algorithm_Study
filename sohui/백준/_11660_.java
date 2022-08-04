import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11660_ {

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[][]arr=new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int[][]arr_sum=new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				arr_sum[i][j]=arr_sum[i][j-1]+arr_sum[i-1][j]-arr_sum[i-1][j-1]+arr[i][j];
			}
		}
		
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(bf.readLine());
			int[] start= {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			int[] end= {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			int result=arr_sum[end[0]][end[1]]-arr_sum[end[0]][start[1]-1]-arr_sum[start[0]-1][end[1]]+arr_sum[start[0]-1][start[1]-1];
			System.out.println(result);
			
		}
		
	}

}
