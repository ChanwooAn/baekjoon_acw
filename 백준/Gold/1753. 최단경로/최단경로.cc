#include<bits/stdc++.h>
#define INF 1000000
#define MAX_VERTEX 20001
#define MAX_EDGE 30001
using namespace std;

int d[MAX_VERTEX];
vector<pair<int, int> > a[MAX_EDGE];

void dijkstra(int start) {
    d[start] = 0;
    priority_queue<pair<int, int> > pq;
    pq.push(make_pair(0, start));

    while(!pq.empty()) {
        int current = pq.top().second;
        int distance = -pq.top().first;
        pq.pop();

        if (d[current] < distance) continue;

        for (int i = 0; i < a[current].size(); i++) {
            int next = a[current][i].second;
            int nextDistance = distance + a[current][i].first;
            if (nextDistance < d[next]) {
                d[next] = nextDistance;
                pq.push(make_pair(-nextDistance, next));
            }
        }
    }
}

int main() {
	int v, e;
    scanf("%d %d", &v, &e);

    int start;
    scanf("%d", &start);

    for (int i = 1; i < v + 1; i++)
        d[i] = INF;
    
    for (int i = 0; i < e; i++) {
        int u, v, w;
        scanf("%d %d %d", &u, &v, &w);
        a[u].push_back(make_pair(w, v));
    }

    dijkstra(start);

    for (int i = 1; i < v + 1; i++) {
        if (d[i] == INF)
            printf("INF\n");
        else
            printf("%d\n", d[i]);
    }
}