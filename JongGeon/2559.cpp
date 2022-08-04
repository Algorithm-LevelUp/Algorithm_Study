#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int n, m;
int main() {
	cin >> n >> m;
	vector<int>v;
	int num;
	v.push_back(0);
	for (int i = 0; i < n; i++) {
		cin >> num;
		v.push_back(num+v[i]);
	}

	int back = 0;
	int sum = 0;
	priority_queue<int>pq;
	for (int front = m; front <= n; front++) {
		pq.push(v[front] - v[back++]);
	}

	cout << pq.top();
}