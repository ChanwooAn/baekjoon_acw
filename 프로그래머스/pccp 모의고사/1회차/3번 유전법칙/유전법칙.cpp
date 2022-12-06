#include <string>
#include <vector>

using namespace std;



vector<string> solution(vector<vector<int>> queries) {
    vector<string> answer;
    for(int i=0;i<queries.size();i++){
        int childNow=queries[i][1];
        int n=queries[i][0];
        vector<int> childs;
        
        int parent=0;
        int child=0;
        if(n==1){
            answer.push_back("Rr");
            continue;
        }
        while(n>1){
            n--;
            parent=childNow/4;
            child=childNow%4;
            
            if(child!=0){
                parent++;
            }else{
                child=4;
            }
            childs.push_back(child);
            childNow=parent;
        }
        
        int ch=0;
        while(!childs.empty()){
            ch=childs.back();
            childs.pop_back();
            if(ch==2 || ch==3){
                continue;
            }else if(ch==1){
                answer.push_back("RR");
                break;
            }else{
                answer.push_back("rr");
                break;
            }
        }
        
        if(ch==2 || ch==3){
            answer.push_back("Rr");
        }
        
        
    }
    
    
    
    return answer;
}