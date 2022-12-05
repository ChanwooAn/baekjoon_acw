#include <string>
#include <vector>

using namespace std;


vector<string> solution(vector<vector<int>> queries) {
    vector<string> answer;

    for (int i = 0; i < queries.size(); i++) {
        int n = queries[i][0];
        int p = queries[i][1];
        vector<int> child;
        
        if (n == 1) {
            answer.push_back("Rr");
            continue;
        }

        if (n == 2) {
            if (p == 1) {
                answer.push_back("RR");
            }
            else if (p == 4) {
                answer.push_back("rr");
            }
            else {
                answer.push_back("Rr");
            }
            continue;
        }


        while (n > 2) {
            int parentNow = p / 4;
            int childNow = p % 4;
            if (childNow != 0) {
                parentNow++;
            }
            if (childNow == 0)childNow = 4;
            child.push_back(childNow);

            p = parentNow;
            n--;
        }

        //2gen에서 판단
        if (p == 1) {
            answer.push_back("RR");
            continue;
        }
        else if (p == 4) {
            answer.push_back("rr");
            continue;
        }
        else {
            int nextChild = 0;
            while (n != queries[i][0]) {
                n++;
                nextChild = child.back();
                child.pop_back();
                if (nextChild == 2 || nextChild == 3) {
                    continue;
                }
                else {
                    break;
                }
            }
            if (nextChild == 1) {
                answer.push_back("RR");
                continue;
            }
            else if (nextChild == 4) {
                answer.push_back("rr");
                continue;
            }
            else {
                answer.push_back("Rr");
                continue;
            }
        }


    }
   


    return answer;
}