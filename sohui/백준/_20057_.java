import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20057_ { // 마법사 상어와 토네이도
	static int n, arr[][], answer;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {-1,0,1,0};
	
	public static void main(String[] args) throws IOException { 
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(bf.readLine());
		arr=new int[n][n];
		answer=0;
		
		for(int i=0; i<n; i++) { // input
			st=new StringTokenizer(bf.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		search();
		System.out.println(answer);
	}

	private static void search() {
		int x=n/2, y=n/2, d=1, idx=0, count=0;
		while(d<n) {
			count+=1;
			for(int i=0; i<d; i++) {
				x+=dx[idx];
				y+=dy[idx];
				int temp=0;
				if(arr[x][y]>0) {
					if(idx==0) { // 좌
						if(x-2>=0) {
							arr[x-2][y]+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}else {
							answer+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}
						if(x-1>=0) {
							arr[x-1][y]+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}else {
							answer+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}
						if(x+1<n) {
							arr[x+1][y]+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}else {
							answer+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}
						if(x+2<n) {
							arr[x+2][y]+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}else {
							answer+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}
						if(x-1>=0 && y-1>=0) {
							arr[x-1][y-1]+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}else {
							answer+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}
						if(x+1<n && y-1>=0) {
							arr[x+1][y-1]+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}else {
							answer+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}
						if(y-2>=0) {
							arr[x][y-2]+=(int) (arr[x][y]*0.05);
							temp+=(int) (arr[x][y]*0.05);
						}else {
							answer+=(int) (arr[x][y]*0.05);
							temp+=(int) (arr[x][y]*0.05);
						}
						if(x-1>=0 && y+1<n) {
							arr[x-1][y+1]+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}else {
							answer+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}
						if(x+1<n && y+1<n) {
							arr[x+1][y+1]+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}else {
							answer+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}
					}else if(idx==1) { // 하
						if(x-1>=0 && y-1>=0) {
							arr[x-1][y-1]+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}else {
							answer+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}
						if(x-1>=0 && y+1<n) {
							arr[x-1][y+1]+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}else {
							answer+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}
						if(y+1<n) {
							arr[x][y+1]+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}else {
							answer+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}
						if(y-1>=0) {
							arr[x][y-1]+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}else {
							answer+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}
						if(y+2<n) {
							arr[x][y+2]+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}else {
							answer+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}
						if(y-2>=0) {
							arr[x][y-2]+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}else {
							answer+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}
						if(x+1<n && y+1<n) {
							arr[x+1][y+1]+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}else {
							answer+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}
						if(x+1<n && y-1>=0) {
							arr[x+1][y-1]+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}else {
							answer+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}
						if(x+2<n) {
							arr[x+2][y]+=(int) (arr[x][y]*0.05);
							temp+=(int) (arr[x][y]*0.05);
						}else {
							answer+=(int) (arr[x][y]*0.05);
							temp+=(int) (arr[x][y]*0.05);
						}
					}else if(idx==2) { // 우
						if(x-2>=0) {
							arr[x-2][y]+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}else {
							answer+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}
						if(x-1>=0) {
							arr[x-1][y]+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}else {
							answer+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}
						if(x+1<n) {
							arr[x+1][y]+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}else {
							answer+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}
						if(x+2<n) {
							arr[x+2][y]+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}else {
							answer+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}
						if(x-1>=0 && y-1>=0) {
							arr[x-1][y-1]+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}else {
							answer+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}
						if(x+1<n && y-1>=0) {
							arr[x+1][y-1]+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}else {
							answer+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}
						if(y+2<n) {
							arr[x][y+2]+=(int) (arr[x][y]*0.05);
							temp+=(int) (arr[x][y]*0.05);
						}else {
							answer+=(int) (arr[x][y]*0.05);
							temp+=(int) (arr[x][y]*0.05);
						}
						if(x-1>=0 && y+1<n) {
							arr[x-1][y+1]+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}else {
							answer+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}
						if(x+1<n &&y+1<n) {
							arr[x+1][y+1]+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}else {
							answer+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}
					}else { // 상
						if(x-1>=0 && y-1>=0) {
							arr[x-1][y-1]+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}else {
							answer+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}
						if(x-1>=0 && y+1<n) {
							arr[x-1][y+1]+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}else {
							answer+=(int) (arr[x][y]*0.1);
							temp+=(int) (arr[x][y]*0.1);
						}
						if(y+1<n) {
							arr[x][y+1]+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}else {
							answer+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}
						if(y-1<n) {
							arr[x][y-1]+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}else {
							answer+=(int) (arr[x][y]*0.07);
							temp+=(int) (arr[x][y]*0.07);
						}
						if(y+2<n) {
							arr[x][y+2]+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}else {
							answer+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}
						if(y-2>=0) {
							arr[x][y-2]+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}else {
							answer+=(int) (arr[x][y]*0.02);
							temp+=(int) (arr[x][y]*0.02);
						}
						if(x+1<n && y+1<n) {
							arr[x+1][y+1]+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}else {
							answer+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}
						if(x+1<n && y-1>=0) {
							arr[x+1][y-1]+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}else {
							answer+=(int) (arr[x][y]*0.01);
							temp+=(int) (arr[x][y]*0.01);
						}
						if(x-2>=0) {
							arr[x-2][y]+=(int) (arr[x][y]*0.05);
							temp+=(int) (arr[x][y]*0.05);
						}else {
							answer+=(int) (arr[x][y]*0.05);
							temp+=(int) (arr[x][y]*0.05);
						}
					}
					if(idx==0) {
						if(y-1>=0) {
							arr[x][y-1]+=(int) (arr[x][y]-temp);
						}else {
							answer+=(int)  (arr[x][y]-temp);
						}
					}else if(idx==1) {
						if(x+1<n) {
							arr[x+1][y]+=(int) (arr[x][y]-temp);
						}else {
							answer+=(int)  (arr[x][y]-temp);
						}
					}else if(idx==2) {
						if(y+1<n) {
							arr[x][y+1]+=(int) (arr[x][y]-temp);
						}else {
							answer+=(int)  (arr[x][y]-temp);
						}
					}else {
						if(x-1>=0) {
							arr[x-1][y]+=(int) (arr[x][y]-temp);
						}else {
							answer+=(int)  (arr[x][y]-temp);
						}
					}
					arr[x][y]=0;
				}
			}
			idx+=1;
			if(idx>=4)idx=0;
			if(count==2) {
				if(d!=n-1) {
					count=0;
					d+=1;
				}
			}
			if(d==n-1 && count==3) break;
		}
	}
}