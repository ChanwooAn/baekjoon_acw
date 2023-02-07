#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <vector>
#include<algorithm>
using namespace std;

int parent[100001];
int N, M;
class Edge {
public:
	int a, b;
	int distance;
	Edge(int a,int b,int distance) {
		this->a = a;
		this->b = b;
		this->distance = distance;
	}

	bool operator < (Edge& e) {
		return distance < e.distance;
	}



};

vector<Edge> v;

int findParent(int a) {
	if (parent[a] == a) {
		return a;
		
	}
	else {
		parent[a] = findParent(parent[a]);
		return parent[a];

	}
}

void makeUnion(int a, int b) {
	int parentA, parentB;
	parentA = findParent(a);
	parentB = findParent(b);
	if (parentA < parentB) {
		parent[parentB] = parentA;
	}
	else {
		parent[parentA] = parentB;
	}
}

bool isCycle(int a, int b) {
	return findParent(a) == findParent(b);
}

int main() {
	int sum = 0;
	cin >> N >> M;
	for (int i = 1; i < N + 1; i++) {
		parent[i] = i;
	}

	for (int i = 0,a,b,c; i < M; i++) {
		cin >> a >> b >> c;
		v.push_back(Edge(a, b, c));		
	}
	sort(v.begin(), v.end());


	int max = 0;
	for (int i = 0,a,b,c; i < v.size(); i++) {
		a = v[i].a;
		b = v[i].b;
		c = v[i].distance;
		if (!isCycle(a, b)) {

			makeUnion(a, b);
			sum += c;
			if (c > max) {
				max = c;
			}
		}
	}

	cout << sum-max  << endl;



}