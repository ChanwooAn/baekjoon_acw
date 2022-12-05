#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;


void permutation(vector<vector<int>> & answer ,vector<bool> &visit,int numOfGame,int sizeNow,int numOfPeople,vector<int> arr) {
	
	if (sizeNow == numOfGame) {
		answer.push_back(arr);
	}
	

	for (int i = 0; i < numOfPeople; i++) {
		if (visit[i] == false) {
			visit[i] = true;
			arr.push_back(i);
			permutation(answer, visit,numOfGame,sizeNow+1,numOfPeople,arr);
			arr.pop_back();
			visit[i] = false;
		}
	}

}

int solution(vector<vector<int>> ability) {
	int answer = 0;
	
	int numOfGame = ability[0].size();
	int numOfStudent = ability.size();
	vector<vector<int>> ans;
	vector<bool> visit;
	for (int i = 0; i < numOfStudent; i++) visit.push_back(false);

	vector<int> tmp;
	permutation(ans, visit, numOfGame,0,numOfStudent,tmp);

	
	for (int i = 0; i < ans.size(); i++) {
		int tmp = 0;
		for (int j = 0; j < numOfGame; j++) {
			tmp += ability[ans[i][j]][j];
		}
		if (tmp > answer) {
			answer = tmp;
		}
	}

	
	return answer;
}