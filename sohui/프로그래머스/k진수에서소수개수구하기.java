
public class k진수에서소수개수구하기 {
	 public int solution(int n, int k) {
	     	int answer = 0;

			// n진수 변환
			String temp = "";
			while (n > 0) {
				temp += n % k;
				n = n / k;
			}
			char[] n_num = new char[temp.length()];
			int idx = 0;
			for (int i = temp.length() - 1; i >= 0; i--) {
				n_num[idx++] = temp.charAt(i);
			}

			for (int i = 0; i < n_num.length; i++) {
				String x = "";
				for (int j = i; j < n_num.length; j++) {
					x += n_num[j];
					if (i - 1 >= 0 && j + 1 < n_num.length) {
						if (n_num[i - 1] == '0' && n_num[j + 1] == '0') { // 양쪽에 0이 있는 경우
							if (check_prime(x)) answer += 1;
							continue;
						}
					}
					if (j + 1 < n_num.length && i - 1 < 0) {
						if (n_num[j + 1] == '0') { // 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
							if (check_prime(x)) answer += 1;
							continue;
						}
					}
					if (i - 1 >= 0 && j + 1 == n_num.length) { // 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
						if (n_num[i - 1] == '0') {
							if (check_prime(x)) answer += 1;
							continue;
						}
					}
					if (i - 1 < 0 && j + 1 == n_num.length) { // 양쪽에 아무것도 없는 경우
						if (check_prime(x)) answer += 1;
						continue;
					}
				}
			}
			return answer;
		}

		private static boolean check_prime(String x) {
	    	boolean check=true;
			if(x.contains("0")) {
				return false;
			}else if(x.equals("1")) {
				return false;
			}else {
				long y=Long.parseLong(x);
				for(int i=2; i<=Math.sqrt(y); i++) {
					if(y%i==0) {
						return false;
					}
				}
			}
			return true;	
		}
}
