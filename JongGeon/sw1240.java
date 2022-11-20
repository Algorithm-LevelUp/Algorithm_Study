import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sw1240 {
	static String code[] = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());

		
		for (int t = 1; t <= test; t++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String str[] = new String[n];
			
			for (int i = 0; i < n; i++) {
				str[i] = br.readLine();
			}
			
			for (int i = 0; i < n; i++) {
				int j;
				boolean f = false;
				for (j = m - 1; j >= 0; j--) {
					if (str[i].charAt(j) == '1') {
						f=true;
						break;
					}
				}
				if(!f) {
					continue;
				}
				int cnt = 0;
				int back = j+1;
				ArrayList<String> arr = new ArrayList<>();
				for (int k = j; k >= 0; k--) {
					
					if (cnt++ == 6) {
						cnt = 0;
						arr.add(str[i].substring(k, back));
						back = k;
					}
					
					if (arr.size() == 8)
						break;
				}
				int num[] = new int[8];
				for (int k = 0; k < 8; k++) {
					num[k] = transform(arr.get(k));
				}
				if (isEncrypt(num)) {
					int res=0;
					for(int k=0; k<8; k++) {
						res+=num[k];
					}
					System.out.println("#"+t+" "+res);
					break;
				}else {
					System.out.println("#"+t+" "+0);
					break;
				}
				

			}
		}
	}

	static int transform(String s) {
		int n1 = 0;
		for(int i=0; i<10; i++) {
			if(s.equals(code[i])) {
				n1 = i;
				break;
			}
		}
		return n1;
	}

	static boolean isEncrypt(int[] num) {
		int n1 = (num[7] + num[5] + num[3] + num[1]) * 3 + num[0] + num[2] + num[4] + num[6];
		if (n1 % 10 == 0) {
			return true;
		}
		return false;
	}
}
