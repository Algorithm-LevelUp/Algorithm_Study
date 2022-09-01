import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경사로
public class _14890_ {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][n];
		boolean[][] arr_check=new boolean[n][n];
		for (int i = 0; i < n; i++) { // input
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer=0;
		// 행
		for(int i=0; i<n; i++) {
			int idx=0;
			int level=0;
			while(idx+1<n) {
				level=arr[i][idx]; // 현재 높이
				if(arr[i][idx+1] == level) { // 높이가 같다면
					idx+=1;
				}else if(arr[i][idx+1] == level +1 ) { // 높이가 1 높다면
					boolean flag=true;
					for(int j=0; j<l; j++) {
						if(idx-j>=0 && !arr_check[i][idx-j] && arr[i][idx-j] == level) { // 아직 경사로가 없고, 경사로 길이만큼 충분하면
							arr_check[i][idx-j]=true;
						}else { // 경사로가 이미 설치되었거나, 길이가 부족하면
							flag=false;
							break;
						}
					}
					if(!flag) {
						break;
					}else {
						idx+=1;
					}
				}else if(arr[i][idx+1]== level -1) { // 높이가 1 낮다면
					boolean flag=true;
					for(int j=0; j<l; j++) {
						if(idx+1+j<n && !arr_check[i][idx+1+j] && arr[i][idx+1+j]==level-1) { // 아직 경사로가 없고, 경사로 길이만큼 충분하면
							arr_check[i][idx+1+j]=true;
						}else {
							flag=false;
							break;
						}
					}
					if(!flag) {
						break;
					}else {
						idx+=l;
					}
				}else if(Math.abs(arr[i][idx+1] - level) >1 ) { // 높이 차이가 2이상이면
					break;
				}
				if(idx==n-1) {
					answer+=1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr_check[i][j]=false;
			}
		}
		
		//열
		for(int i=0; i<n; i++) {
			int idx=0;
			int level=0;
			while(idx+1<n) {
				level=arr[idx][i]; // 현재 높이
				if(arr[idx+1][i] == level) { // 높이가 같다면
					idx+=1;
				}else if(arr[idx+1][i] == level +1 ) { // 높이가 1 높다면
					boolean flag=true;
					for(int j=0; j<l; j++) {
						if(idx-j>=0 && !arr_check[idx-j][i] && arr[idx-j][i] == level) { // 아직 경사로가 없고, 경사로 길이만큼 충분하면
							arr_check[idx-j][i]=true;
						}else { // 경사로가 이미 설치되었거나, 길이가 부족하면
							flag=false;
							break;
						}
					}
					if(!flag) {
						break;
					}else {
						idx+=1;
					}
				}else if(arr[idx+1][i]== level -1) { // 높이가 1 낮다면
					boolean flag=true;
					for(int j=0; j<l; j++) {
						if(idx+1+j<n && !arr_check[idx+1+j][i] && arr[idx+1+j][i]==level-1) { // 아직 경사로가 없고, 경사로 길이만큼 충분하면
							arr_check[idx+1+j][i]=true;
						}else {
							flag=false;
							break;
						}
					}
					if(!flag) {
						break;
					}else {
						idx+=l;
					}
				}else if(Math.abs(arr[idx+1][i] - level) >1 ) { // 높이 차이가 2이상이면
					break;
				}
				if(idx==n-1) {
					answer+=1;
				}
			}
		}
		System.out.println(answer);
	}
}
