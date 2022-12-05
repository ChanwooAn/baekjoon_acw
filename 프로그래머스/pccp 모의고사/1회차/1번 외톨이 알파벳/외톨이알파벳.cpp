#include <iostream>
#include <algorithm>

using namespace std;

const int numOfAlphabet = 'z' - 'a';
bool checkArr[numOfAlphabet] = { false, };


string solution(string input_string) {
	string answer = "";
	string tmp = "";
	for (int i = 0; i < numOfAlphabet; i++) {
		checkArr[i] = false;
	}//배열 초기화

	char prev = input_string[0];
	checkArr[prev - 'a'] = true;

	for (int i = 1; i < input_string.length(); i++) {
		if (input_string[i] == prev) {
			continue;
		}
		else {
			prev = input_string[i];
			if (checkArr[input_string[i] - 'a'] == false) {
				//알파벳을 처음 만났을 경우
				checkArr[input_string[i] - 'a'] = true;
			}
			else {
				tmp += input_string[i];
			}
		}

	}

	sort(&tmp[0], &tmp[0] + tmp.length());
	answer += tmp[0];

	prev = tmp[0];
	for (int i = 1; i < tmp.length(); i++) {
		if (tmp[i] == prev) {
			continue;
		}
		else {
			prev = tmp[i];
			answer += tmp[i];
		}
	}
	if (tmp.length() == 0) {
		answer = "N";
	}


	return answer;
}