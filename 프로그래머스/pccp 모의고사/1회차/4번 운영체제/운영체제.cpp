#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

struct Program {
    int niceVal;
    long long arrivalTime;
    int executionTime;
    Program(int nice, long long arrive, int execute) : niceVal(nice), arrivalTime(arrive), executionTime(execute) {}

};
struct cmp {
    bool operator()(Program a, Program b) {
         if (a.niceVal == b.niceVal) {
            return a.arrivalTime > b.arrivalTime;
        }
        return a.niceVal > b.niceVal;
    }
};
bool compareProgram(vector<int> a, vector<int> b) {
    if (a[1] == b[1]) {
        return a[0] < b[0];
    }
    else {
        return a[1] < b[1];
    }
}//일단 시간 순으로 sort, 시간 같을 경우에는 nice val로 결정


vector<long long> solution(vector<vector<int>> program) {
    vector<bool> visit;
    vector<long long> answer;
    priority_queue<Program, vector<Program>, cmp> possibleProgram;
    sort(program.begin(), program.end(), compareProgram);
    answer.assign(11, 0);
    visit.assign(program.size(), false);

    possibleProgram.push(Program(program[0][0],program[0][1],program[0][2]));


    int totalProgramSize = program.size();
    long long timeNow = program[0][1];
    int nextProgram = 1;
    for (int i = 0; i < totalProgramSize; i++) {
        Program programNow = possibleProgram.top(); possibleProgram.pop();
        int niceVal = programNow.niceVal;
        long long arrivalTime = programNow.arrivalTime;
        int executionTime = programNow.executionTime;

        long long delayTime = timeNow - arrivalTime;

        answer[niceVal] += delayTime;
        timeNow = timeNow + executionTime;

        if (possibleProgram.empty() && nextProgram<totalProgramSize &&program[nextProgram][1]>timeNow) {
            timeNow = program[nextProgram][1];
        }

        for (int j = nextProgram; j < totalProgramSize; j++) {
            if (program[j][1] <= timeNow) {
                possibleProgram.push(Program(program[j][0], program[j][1], program[j][2]));
                nextProgram = j + 1;
            }
            else {
                break;
            }
        }

    }
    answer[0] = timeNow;
    

    return answer;
}