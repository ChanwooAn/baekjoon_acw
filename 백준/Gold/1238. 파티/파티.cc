#include <stdio.h>

int main(){
	int n,m,x,i,j,k,max;
	int map[1001][1001];
	
    //입력 받기 및 초기화
	scanf("%d %d %d",&n,&m,&x);
	for(i=1;i<=n;i++){
		for(j=1;j<=n;j++)
			map[i][j] = 100000;
		map[i][i]=0;
    }
	
    //도로 길이 입력받기
	while(m--){
		scanf("%d %d %d",&i,&j,&k);
		map[i][j] = k;
	}
	
    //플로이드 와샬 알고리즘
	for(k=1;k<=n;k++){
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++){
				if(map[i][j] > map[i][k]+map[k][j])
					map[i][j] = map[i][k]+map[k][j];
			}
	}
	
    //왕복거리 최대값 찾기
	max = 0;
	for(i=1;i<=n;i++){
		if(map[i][x]+map[x][i] > max)
			max = map[i][x]+map[x][i];
	}
	printf("%d\n",max);	
	
	return 0;
}