#include <iostream>
#include <math.h>
#include <algorithm>
#include <utility>
#include <queue>
#include <vector>

using namespace std;
vector<int>v;
int dp[500][500];
int mergeFile(int start, int end) {
	int maximum = 0;
	if (start == end) {
		return v[start];
	}
	for (int i = start; i < end; i++) {
		
		if (maximum < mergeFile(start, i) + mergeFile(i + 1, end)) {
			maximum= mergeFile(start, i) + mergeFile(i + 1, end);
		}
	}
	return maximum;
	
}

int main() {
	int test = 0;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int k = 0;
		cin >> k;

		for (int i = 0; i < k; i++) {
			int num;
			cin >> num;
			v.push_back(num);
		}
		
		cout << mergeFile(0, k-1) <<"\n";
	}
}