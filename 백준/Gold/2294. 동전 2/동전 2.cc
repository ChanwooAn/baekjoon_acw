#include <iostream>
using namespace std;





int arr[100];
int cost[10001]={0,};
int n,k;


int main() {
	int count=0;
	cin>>n>>k;
	
	for(int i=0;i<k+1;i++){
		cost[i]=10001;
	}// max
	
	for(int i=0;i<n;i++){
		cin>>arr[i];
		if(arr[i]<k+1){
			cost[arr[i]]=1;
		}
	}
	
	for(int i=1;i<k+1;i++){
		for(int j=0;j<n;j++){
			if(i-arr[j]<0){
				continue;
			}
			
			if(cost[i]>cost[i-arr[j]]+1){
				cost[i]=cost[i-arr[j]]+1;
			}
			
		}
	}
    if(cost[k]!=10001){
        cout<<cost[k];
    }
    else{
        cout<<-1;
    }

	return 0;
}