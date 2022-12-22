#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

int arr[301][301];
int tmp[301][301];
int N, M, R;

int turn(int dep) {
	for (int i = dep; i < M-1-dep; i++) {
		tmp[dep][i] = arr[dep][i + 1];
	}//top

	for (int i = dep; i < M - 1 - dep; i++) {
		tmp[N-dep-1][i+1] = arr[N-dep-1][i];
	}//bottom

	for (int i = dep; i < N - 1 - dep; i++) {
		tmp[i+1][dep] = arr[i][dep];
	}//left

	for (int i = dep; i < N - 1 - dep; i++) {
		tmp[i][M-1-dep] = arr[i+1][M-1-dep];
	}//right

	return 0;
}

int sol() {
	int turnCnt = 0;
	int maxDepth = min(M, N) / 2;

	while (turnCnt < R) {
		int dep = 0;
		
		while (dep < maxDepth) {
			turn(dep);
			dep++;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp[i][j];
			}
		}

		turnCnt++;
	}
	
	
	return 0;
}

int main() {
	cin >> N >> M >>R;
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
			tmp[i][j] = arr[i][j];
		}
	}

	sol();
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cout << tmp[i][j] << " ";
		}
		cout << endl;
	}
}