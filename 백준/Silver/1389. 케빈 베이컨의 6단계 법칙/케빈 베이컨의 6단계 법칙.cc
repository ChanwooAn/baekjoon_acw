#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;
#define MAX 100000

queue<int> q;
vector<vector<int>> distances;
vector<bool> visit;
int n, m;
void floid() {
	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				distances[i][j] = min(distances[i][j], distances[i][k] + distances[k][j]);
			}
		}
	}
}

int main() {
	cin >> n >> m;
	distances.assign(n, vector<int>(n, MAX));
	visit.assign(n, false);
	for (int i = 0,a,b; i < m; i++) {
		cin >> a >> b;
		distances[a - 1][b - 1] = 1;
		distances[b - 1][a - 1] = 1;

	}

	

	floid();

	int answerSum = MAX;
	int answerNum = -1;
	for (int i = 0; i < n; i++) {
		int sum = 0;

		for (int f = 0; f < n; f++) {
			if (f == i) {
				continue;
			}
			sum += distances[i][f];
		}
		if (sum < answerSum) {
			answerSum = sum;
			answerNum = i+1;
		}
	}
	printf("%d", answerNum);

}