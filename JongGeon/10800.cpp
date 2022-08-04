#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
using namespace std;

int n, n1, n2;

vector<pair<pair<int,int>, int>>v;

int sum[200001];// map

int res[200001];
int cArr[200001];
int sArr[2001];
int main() {
	cin >> n;
	v.push_back({ { 0 , 0},-1 });
	for (int i = 0; i < n; i++) {
		cin >> n1 >> n2;
		v.push_back({ { n2,n1 }, i });
	}
	sort(v.begin(), v.end());
	
	for (int i = 1; i <= n; i++) {
		sum[i]= sum[i-1] + v[i].first.first;
	}


	int total = sum[n];
	for (int i = 1; i <= n; i++) {
		int s = v[i].first.first;
		int c = v[i].first.second;
		int idx = v[i].second;
		
		sArr[s] += s;
		cArr[c] += s;
		res[idx] = sum[i] - sArr[s] - cArr[c] + s;
		if (i != 0 && (v[i - 1].first.first == s) && (v[i - 1].first.second == c)) {
			res[idx] = res[v[i - 1].second];
		}
	}

	for (int i = 0; i < v.size()-1; i++) {
		cout << res[i] << "\n";
	}
}
